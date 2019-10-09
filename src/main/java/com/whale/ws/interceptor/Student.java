package com.whale.ws.interceptor;

/**
 * @author wangshuai
 * @date 2019/9/19 10:19
 */
public class Student implements People {

    @Override
    public void workOff() {
        System.out.println("上班啦");
    }
}
