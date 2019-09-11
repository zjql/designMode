package createModel.singletonMode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zj
 * @date 2019/9/11 9:35
 * 登记式单例(可忽略)  类似Spring里面的方法，将类名注册，下次从里面直接获取。
 */
public class SingletonRegister {

    private static Map<String,SingletonRegister> singletonRegisterMap = new HashMap<String, SingletonRegister>();

    static {
        SingletonRegister singletonRegister = new SingletonRegister();
        singletonRegisterMap.put(SingletonRegister.class.getName(),singletonRegister);
    }

    //保护的默认构造子
    protected SingletonRegister(){}
    //静态工厂方法,返还此类惟一的实例
    public static SingletonRegister getInstance(String name) {
        if(name == null) {
            name = SingletonRegister.class.getName();
            System.out.println("name == null"+"--->name="+name);
        }
        if(singletonRegisterMap.get(name) == null) {
            try {
                singletonRegisterMap.put(name, (SingletonRegister) Class.forName(name).newInstance());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return singletonRegisterMap.get(name);
    }
    //一个示意性的商业方法
    public String about() {
        return "Hello, I am RegSingleton.";
    }
    public static void main(String[] args) {
        SingletonRegister singletonRegister = SingletonRegister.getInstance(null);
        System.out.println(singletonRegister.about());
    }
}
