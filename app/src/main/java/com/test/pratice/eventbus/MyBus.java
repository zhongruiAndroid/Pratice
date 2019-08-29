package com.test.pratice.eventbus;

import android.os.Handler;
import android.os.Looper;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/***
 *   created by zhongrui on 2019/8/29
 */
public class MyBus {
    private Map<Object, List<SubscribeMethod>> cacheMap;
    private Handler handler;

    private static MyBus singleObj;

    private MyBus() {
        cacheMap=new HashMap<>();
        handler=new Handler(Looper.getMainLooper());
    }

    public static MyBus get() {
        if (singleObj == null) {
            synchronized (MyBus.class) {
                if (singleObj == null) {
                    singleObj = new MyBus();
                }
            }
        }
        return singleObj;
    }

    public void post(final Object type) {
        Set<Object>set=cacheMap.keySet();
        Iterator<Object> iterator = set.iterator();
        while (iterator.hasNext()){
            final Object obj=iterator.next();
            List<SubscribeMethod> list = cacheMap.get(obj);
            for (final SubscribeMethod method:list) {
                if (method.getType().isAssignableFrom(type.getClass())) {
                    switch (method.getThreadMode()){
                        case MAIN:
                            if(Looper.getMainLooper()==Looper.myLooper()){
                                invoke(type,obj,method);
                            }else{
                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        invoke(type,obj,method);
                                    }
                                });
                            }
                        break;
                        case BACKGROUND:
                            if(Looper.getMainLooper()==Looper.myLooper()){
                                new Thread(new Runnable() {
                                    @Override
                                    public void run() {
                                        invoke(type,obj,method);
                                    }
                                }).start();
                            }else{
                                invoke(type,obj,method);
                            }
                        break;
                    }
                }
            }
        }
    }

    private void invoke(Object type, Object obj, SubscribeMethod method) {
        try {
            method.getMethod().invoke(obj,type);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public void register(Object object) {
        List<SubscribeMethod> subscribeMethods = cacheMap.get(object);
        if(subscribeMethods==null){
            subscribeMethods=findMethod(object);
            cacheMap.put(object,subscribeMethods);
        }else{

        }
    }

    private List<SubscribeMethod> findMethod(Object object) {
        List<SubscribeMethod> list=new ArrayList<>();

        Class clazz=object.getClass();

        while (clazz!=null){
            String name = clazz.getName();
            if(name.startsWith("java.")||name.startsWith("javax.")||name.startsWith("android.")){
                break;
            }
            Method[] declaredMethods = clazz.getDeclaredMethods();

            for (Method method:declaredMethods){
                Subscribe annotation = method.getAnnotation(Subscribe.class);
                if(annotation==null){
                    continue;
                }
                Class<?>[] parameterTypes = method.getParameterTypes();
                if(parameterTypes.length!=1){
                    continue;
                }
                ThreadMode threadMode = annotation.threadMode();

                SubscribeMethod subscribeMethod=new SubscribeMethod();
                subscribeMethod.setMethod(method);
                subscribeMethod.setThreadMode(threadMode);
                subscribeMethod.setType(parameterTypes[0]);

                list.add(subscribeMethod);
            }
            clazz=clazz.getSuperclass();
        }



        return list;
    }

    public void unRegister(Object object) {

    }
}
