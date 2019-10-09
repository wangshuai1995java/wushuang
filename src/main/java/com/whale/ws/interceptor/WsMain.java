package com.whale.ws.interceptor;


/**
 * @author wangshuai
 * @date 2019/9/19 10:24
 */
public class WsMain {
    public static void main(String[] args) {
        People people = new Student();
        Interceptor interceptor = new Rush();
        People bean =  ProxyBeanFactory.getBean(people, interceptor);
        bean.workOff();

    }
}
