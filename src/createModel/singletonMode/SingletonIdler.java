package createModel.singletonMode;

/**
 * @author zj
 * @date 2019/9/10 15:11
 * 单例懒汉式  在第一次调用的时候实例化自己
 */
public class SingletonIdler {
    /**
     * Singleton通过将构造方法限定为private避免了类在外部被实例化，
     * 在同一个虚拟机范围内，Singleton的唯一实例只能通过getInstance()方法访问。
     */
    private SingletonIdler(){}

    private static SingletonIdler single = null;
    /**
     * 普通
     * @return
     */
    public static SingletonIdler getInstance(){
        if(null == single ){
            single = new SingletonIdler();
        }
        return single;
    }

    /**
     * 线程同步
     * 关键词 synchronized
     * 说明：在并发编程中存在线程安全问题，主要原因有：
     *       1.存在共享数据 2.多线程共同操作共享数据。
     *       关键字synchronized可以保证在同一时刻，只有一个线程可以执行某个方法或某个代码块，
     *       同时synchronized可以保证一个线程的变化可见（可见性），即可以代替volatile。
     * @return
     */
    public static synchronized SingletonIdler getInstanceSyn(){
        if(null == single){
            single = new SingletonIdler();
        }
        return single;
    }

    /**
     * 双重检查锁定
     * @return
     */
    public static SingletonIdler getInstanceDouble(){
        if(null == single){
            synchronized (SingletonIdler.class){
                if( null == single){
                    single = new SingletonIdler();
                }
            }
        }
        return single;
    }
}
