package com.whale.ws.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @author wangshuai
 * @date 2019/10/8 19:10
 */
public class TBObserver implements Observer{
    @Override
    public void update(Observable o, Object product) {
        String newProduct = (String)product;
        System.err.println("新产品"+newProduct+"同步到淘宝");
    }
}
