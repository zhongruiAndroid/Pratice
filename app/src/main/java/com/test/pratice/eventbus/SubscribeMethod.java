package com.test.pratice.eventbus;

import java.lang.reflect.Method;

/***
 *   created by zhongrui on 2019/8/29
 */
public class SubscribeMethod {
    private Method method;
    private ThreadMode threadMode;
    private Class<?> type;

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public ThreadMode getThreadMode() {
        return threadMode;
    }

    public void setThreadMode(ThreadMode threadMode) {
        this.threadMode = threadMode;
    }

    public Class<?> getType() {
        return type;
    }

    public void setType(Class<?> type) {
        this.type = type;
    }
}
