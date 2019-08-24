package com.testfeflection;

import com.testfeflection.bean.AndroidBook;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MyClass {
    public static void main(String[] args) {
//        System.out.println("hello word你好世界");
//        System.out.println("===========");
        testOne();
//        test2();
    }
    public static void testOne(){
        try {
            Class clazz=Class.forName("com.testfeflection.bean.AndroidBook");
            AndroidBook book = (AndroidBook) clazz.newInstance();
            Field[] fields = clazz.getFields();
            Field[] declaredFields = clazz.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                System.out.println(fields[i].getName());
            }
            System.out.println("===========");
            for (int i = 0; i < declaredFields.length; i++) {
                System.out.println(declaredFields[i].getName());
            }
            System.out.println("===========");
            Field androidBookWidth = clazz.getDeclaredField("androidBookWidth");
            System.out.println(book.getAndroidBookWidth());
            androidBookWidth.setAccessible(true);
            androidBookWidth.set(book,10);
            System.out.println(book.getAndroidBookWidth());
            int width = (int) androidBookWidth.get(book);
            book.setBookWidth(width);
            System.out.println(width);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void test2(){
        try {
            Class clazz=Class.forName("com.testfeflection.bean.AndroidBook");
            AndroidBook book = (AndroidBook) clazz.newInstance();
            Method[] fields = clazz.getMethods();
            Method[] declaredFields = clazz.getDeclaredMethods();
            for (int i = 0; i < fields.length; i++) {
                System.out.println(fields[i].getName());
            }
            System.out.println("===========");
            for (int i = 0; i < declaredFields.length; i++) {
                System.out.println(declaredFields[i].getName());
            }
            System.out.println("===========");
            System.out.println("===========");
            Method testa = clazz.getDeclaredMethod("testa");
            testa.setAccessible(true);
            testa.invoke(book);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
