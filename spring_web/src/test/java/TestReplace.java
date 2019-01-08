import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

/**
 * @author: zpf
 **/
class TestProtectedClass {
    private String name;
    protected TestProtectedClass(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class ClassA{
    private String code;

//    public String toString(){
//        return new Gson().toJson(this);
//    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
class TestJson{
    private String name;
    private Integer age;
    private ClassA classa;

    public ClassA getClassa() {
        return classa;
    }

    public void setClassa(ClassA classa) {
        this.classa = classa;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
public class TestReplace {

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= 1024 * 1024) ? 1024 * 1024: n + 1;
    }

    public static void main(String[] args) {
        TestJson test = new TestJson();
        HashMap<String,Object> m = new HashMap<>(3);
        m.put("1", 1);
        m.put("2", 1);
        m.put("3", 1);
        m.put("4", 1);
        System.out.println(m);
        System.out.println(tableSizeFor(3306));
    }
    static class TestTransient implements Serializable {
        transient String name;
        private int age;

        public TestTransient(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }




}

