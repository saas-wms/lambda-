import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.DoubleSupplier;

/**
 * 〈功能简述〉<br/>
 * 〈〉
 *
 * @author lzy
 * @date 2018/5/4
 * @since 1.0.0
 */

public class DemoTest {
    @Test
    void anonymous() {
        HelloWorldAnonymousClasses myApp =
                new HelloWorldAnonymousClasses();
        myApp.sayHello();
    }

    @Test
    @DisplayName("lambda的使用场景,可以传递给一个接受函数式接口的方法")
    void process(Runnable r) {
        r.run();
    }

    @Test
    @DisplayName("lambda的使用场景,可以传递给一个接受函数式接口的方法")
    void test1() {
        process(() -> System.out.println("lambda的使用场景,可以传递给一个接受函数式接口的方法"));
    }

    @Test
    @DisplayName("类型")
    void test2() {
        DoubleSupplier supplier = () -> 3;
        System.out.println(supplier.getAsDouble());
    }

//    @Test
//    @DisplayName("环绕执行模式，行为参数化")
//     static String procseeFile() throws IOException {
//        try (BufferedReader b = new BufferedReader(new FileReader("C:\\Users\\Dzy\\Desktop\\a.txt"))) {
//            return b.readLine();
//        }
//
//    }
//
//    /**
//     * 定义一个函数式接口
//     */
//    interface BufferedReaderProcessor{
//       String procseeFile(BufferedReader b) throws IOException;
//    }


}