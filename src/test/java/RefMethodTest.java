import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 〈功能简述〉<br/>
 * 〈方法引用〉
 *
 * @author lzy
 * @date 2018/5/10
 * @since 1.0.0
 */
 class RefMethodTest {

    private Person construntorRef(Supplier<Person> sup){

        return sup.get();
    }

    @Test
    @DisplayName("构造器方法引用")
    void testConstructorRef(){
        Person p=construntorRef(Person::new);
        System.out.println(p);
    }

    private static void print(String s){
        System.out.println(s);
    }

    @Test
    @DisplayName("静态方法引用")
    void testStaticRef(){
        Arrays.asList("aa","bb","cc").forEach(RefMethodTest::print);
    }

    public void demo(Person person){
        System.out.println(person.getAge());
    }
    @Test
    @DisplayName("成员方法引用")
    void testMemberMethodRef(){
        Arrays.asList("aa","bb","cc").forEach(System.out::println);

        Person person = new Person();
        person.setAge(10);
        Function<Person, Integer> getAge = Person::getAge;
        System.out.println(getAge.apply(person));
//        String s="5555";
//        Function<String, Object> sq = (String s1) -> s.length();
//        ToIntFunction<Person> age = Person::getAge;
//        System.out.println("aaa"+age.applyAsInt(person));
//        System.out.println(sq.apply(s));
    }

    @Test
    void testClassMemberMethodRef(){
        Consumer<RefMethodTest> testMemberMethodRef = RefMethodTest::testMemberMethodRef;
        testMemberMethodRef.accept(this);
    }

}