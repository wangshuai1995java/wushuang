package com.whale.ws.interceptor;



/**
 * @author wangshuai
 * @date 2019/9/19 9:54
 */
public class ProxyBeanFactory {
    public static <T> T getBean(T object,Interceptor interceptor){
        return (T)ProxyBeanUtil.getBean(object,interceptor);
    }
}
