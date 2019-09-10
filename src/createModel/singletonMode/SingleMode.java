package createModel.singletonMode;

/**
 * @author zj
 * @date 2019/9/10 15:08
 *     1、单例类只能有一个实例。
 * 　　2、单例类必须自己创建自己的唯一实例。
 * 　　3、单例类必须给所有其他对象提供这一实例。
 */
public class SingleMode {

    public static void main(String[] args) {

        SingletonIdler.getInstance();
        SingletonIdler.getInstanceSyn();
        SingletonIdler.getInstanceDouble();

        SingletonIdlerStatic.getInstance();

        //初始化就初始了所有引用，很占内存空间
        SingletonHungry.getInstance();
    }
}
