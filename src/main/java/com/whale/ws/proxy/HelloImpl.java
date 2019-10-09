package com.whale.ws.proxy;

/**
 * @author wangshuai
 * @date 2019/9/18 17:08
 */
public class HelloImpl implements Hello{
    @Override
    public void sayHello() {
        System.out.println("你好啊,朋友!");
    }
}
