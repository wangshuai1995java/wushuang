package com.whale.ws.proxy;

/**
 * @author wangshuai
 * @date 2019/9/18 17:20
 */
public class WsMain {
    public static void main(String[] args){
        //产生可生产代理对象的实例
        ProxyHandler proxyHandler = new ProxyHandler();
        //代理对象产生(真实对象作为参数)
        Hello hello = (Hello) proxyHandler.bind(new HelloImpl());
        hello.sayHello();
        Hi hi = (Hi)proxyHandler.bind(new HiImpl());
        hi.sayHi();
    }
}
