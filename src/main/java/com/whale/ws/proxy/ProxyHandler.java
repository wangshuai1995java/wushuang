package com.whale.ws.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author wangshuai
 * @date 2019/9/18 17:09
 * 此类的实例用于绑定真实对象并返回代理对象,还包含了代理逻辑方法(执行前后的行为)
 */
public class ProxyHandler implements InvocationHandler {
    //真实对象
    private Object object = null;

    /**
     * @param object 真实对象
     * @return 代理对象
     */
    //真实对象与代理对象建立代理关系,并返回代理对象
    public Object bind(Object object) {
        this.object = object;
        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), this);
    }

    /**
     * @param proxy  这是代理对象,就是bind生成的对象
     * @param method 真实方法的反射
     * @param args   调度方法的参数
     * @return
     * @throws Throwable
     */
    //代理方法逻辑
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("进入代理逻辑方法");
        System.out.println("代理:在真实方法执行之前");
        //这里需要的是真实对象的实例
        method.invoke(object, args);
        System.out.println("代理:在真实方法执行之后");
        return object;
    }
}
