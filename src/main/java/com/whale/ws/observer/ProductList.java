package com.whale.ws.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * @author wangshuai
 * @date 2019/10/8 17:29
 */
public class ProductList extends Observable {
    //静态唯一实例
    private static ProductList instance;
    //产品列表
    public List<String> productList = null;
    //构建方法私有化
    private ProductList(){}
    //懒汉式
    public static ProductList getInstance(){
        if(instance==null){
            instance = new ProductList();
            instance.productList = new ArrayList<String>();
        }
        return instance;
    }
    //增加观察者
    public void addProductListObserver(Observer observer){
        this.addObserver(observer);
    }
    //新增产品
    public void addProduct(String newProduct){
        productList.add(newProduct);
        System.out.println("产品列表新增产品:"+newProduct);
        //设置被观察对象发生变化
        this.setChanged();
        //通过观察者,传递新对象
        this.notifyObservers(newProduct);
    }
}
