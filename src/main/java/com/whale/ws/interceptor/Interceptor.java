package com.whale.ws.interceptor;

/**
 * @author wangshuai
 * @date 2019/9/19 9:52
 */
public interface Interceptor {
    
    void before(Object object);

    void after(Object object);

    void afterReturning(Object object);

    void afterThrowing(Object object);
}
