package com.whale.ws.interceptor;

/**
 * @author wangshuai
 * @date 2019/9/19 10:16
 */
public class Rush implements Interceptor {
    @Override
    public void before(Object object) {
        System.out.println("在执行真实方法之前");
    }

    @Override
    public void after(Object object) {
        System.out.println("在执行真实方法之后");
    }

    @Override
    public void afterReturning(Object object) {
        System.out.println("在执行完返回之后");
    }

    @Override
    public void afterThrowing(Object object) {
        System.out.println("在执行的过程遇到异常");
    }
}
