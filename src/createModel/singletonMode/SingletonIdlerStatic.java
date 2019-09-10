package createModel.singletonMode;

/**
 * @author zj
 * @date 2019/9/10 17:43
 * 懒汉式  静态内部类
 * 既实现了线程安全，又避免了同步带来的性能影响
 */
public class SingletonIdlerStatic {

    private static class LazyHolder{
        private static final SingletonIdlerStatic INSTANCE = new SingletonIdlerStatic();
    }

    private SingletonIdlerStatic(){}

    public static final SingletonIdlerStatic getInstance(){
        System.out.println("获取到懒汉式静态内部类实例");
        return LazyHolder.INSTANCE;
    }
}
