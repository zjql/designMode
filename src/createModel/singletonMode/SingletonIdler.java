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

    private static volatile SingletonIdler single = null;
    /**
     * 普通
     * @return
     */
    public static SingletonIdler getInstance(){
        if(null == single ){
            System.out.println("获取到懒汉式普通实例");
            single = new SingletonIdler();
        }
        return single;
    }

    /**
     * 线程同步
     * @return
     */
    public static synchronized SingletonIdler getInstanceSyn(){
        if(null == single){
            System.out.println("获取到懒汉式线程同步实例");
            single = new SingletonIdler();
        }
        System.out.println("获取到懒汉式线程同步实例，不为null");
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
                    System.out.println("获取到懒汉式双重检查锁定的实例");
                    single = new SingletonIdler();
                }
            }
        }
        System.out.println("获取到懒汉式线程同步实例，不为null");
        return single;
    }
}
