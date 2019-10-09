package com.whale.ws.interceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author wangshuai
 * @date 2019/9/19 10:01
 */
public class ProxyBeanUtil implements InvocationHandler {
    private Object object;
    private Interceptor interceptor = null;

    public static Object getBean(Object object, Interceptor interceptor) {
        ProxyBeanUtil proxyBeanUtil = new ProxyBeanUtil();
        proxyBeanUtil.object = object;
        proxyBeanUtil.interceptor = interceptor;
        return Proxy.newProxyInstance(object.getClass().getClassLoader(), interceptor.getClass().getInterfaces(), proxyBeanUtil);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args){
        Object retObj = null;
        boolean exceptionFlag = false;
        //before
        interceptor.before(object);
        try {
            retObj = method.invoke(object, args);
        } catch (Exception ex) {
            exceptionFlag = true;
        } finally {
            //after
            interceptor.after(object);
        }
        if (exceptionFlag) {
            interceptor.afterThrowing(object);
        } else {
            interceptor.afterReturning(object);
        }
        return retObj;
    }
}
