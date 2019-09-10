package createModel.singletonMode;

/**
 * @author zj
 * @date 2019/9/10 15:22
 * 饿汉式单例类.在类初始化时，已经自行实例化
 */
public class SingletonHungry {
    /**
     * 设定私有的构造方法，避免在外部被实例化（new对象）
     */
    private SingletonHungry(){}

    /**
     * 饿汉式在类创建的同时就已经创建好一个静态的对象供系统使用，以后不再改变，所以天生是线程安全的。
     */
    private static final SingletonHungry SINGLE = new SingletonHungry();

    public static SingletonHungry getInstance(){
        return SINGLE;
    }

}
