import org.apache.commons.collections.Factory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.*;

/**
 * 〈功能简述〉<br/>
 * 〈测试函数式接口传参〉
 *
 * @author lzy
 * @date 2018/5/10
 * @since 1.0.0
 */
 class Demo1Test {
    //过滤方法
    private static List<Person> filterApples(List<Person> inventory, ApplePredicate p) {
        List<Person> result = new ArrayList<>();
        for (Person apple : inventory){
            if (p.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }
    //接口
    public interface ApplePredicate{
        boolean test (Person apple);
    }

    @Test
    void nMingTest(){
        List<Person> inventory=new ArrayList<>();
        Person person = new Person();
        person.setName("red");
        inventory.add(person);
        //方法调用
        List<Person> redApples = filterApples(inventory, new ApplePredicate() {
            public boolean test(Person a){
                return "red".equals(a.name);
            }
        });
        System.out.println(redApples.get(0));
    }
    @Test
    void lambda(){
        List<Person> inventory=new ArrayList<>();
        Person person = new Person();
        person.setName("red");
        inventory.add(person);
        //方法调用
        List<Person> redApples = filterApples(inventory, (Person a) -> "red".equals(a.name));
        System.out.println(redApples.get(0));
    }
    @DisplayName("默认的函数式接口")
    @Test
    void defaultFunction(){
        IntSupplier supplier = () -> 42;
        Callable<Integer> callable=()->42;

        String a="123";
        BooleanSupplier booleanSupplier = () -> a.length() == 0;

        Consumer<Person> personConsumer = (Person persion) -> System.out.println("你真帅");

        IntPredicate intPredicate = (int i) -> i % 2 == 0;
        if(intPredicate.test(100)){
            System.out.println("我是真的没有装箱");
        }
        Predicate<Integer> integerObjectFunction = (Integer i) -> i % 2 == 0;

        if(integerObjectFunction.test(100)){
            System.out.println("我是真的装箱");
        }

        Supplier<Person> personSupplier = Person::new;

        UnaryOperator<Person> personObjectFunction = (Person p) -> p;
        Factory aNew = Person::new;
        Person person = (Person) aNew.create();
        Person apply = personObjectFunction.apply(person);
    }


}