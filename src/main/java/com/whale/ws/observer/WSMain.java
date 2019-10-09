package com.whale.ws.observer;

/**
 * @author wangshuai
 * @date 2019/10/8 17:18
 */
public class WSMain {
    /*扣扣
    * 观察者主类,本例中的ProductList
    *       此类是一个单例模式,实例对象需要static修饰,继承了Observable,成员变量包括
    *                                                   1.实例对象的引用
    *                                                   2.需要监听的对象  本例中的productList
    *                                              成员方法:
    *                                                   1.增加观察者对象(本例中的JD,TB观察者对象)
    *                                                   2.在监听对象执行某个方法后,传递改变
    *                                                           this.setChanged();
    *                                                           this.notifyObservers(newProduct);
    * 各中的观察者,本例中的JD与TB,实现Observer接口,重写update方法
    *        在监听对象发生改变之后,执行相关逻辑
    *        @Override
             public void update(Observable o, Object product) {
                 String newProduct = (String)product;
                 System.err.println("新产品"+newProduct+"同步到京东");
             }
    * */
    //观察者模式测试类Obverver
    public static void main(String[] args){
        ProductList observer = ProductList.getInstance();
        TBObserver tbObserver = new TBObserver();
        JDObserver jdObserver = new JDObserver();
        observer.addProductListObserver(tbObserver);
        observer.addProductListObserver(jdObserver);
        observer.addProduct("mk50");
        observer.addProduct("mk85");
        System.out.println(observer.productList);
    }
}
