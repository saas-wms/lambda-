import lombok.Data;

import java.time.LocalDate;

/**
 * 〈功能简述〉<br/>
 * 〈实体类〉
 *
 * @author lzy
 * @date 2018/5/3
 * @since 1.0.0
 */
@Data
public class Person {

    public enum Sex {
        /**
         * 女
         */
        MALE,
        /**
         * 男
         */
        FEMALE
    }

    /**
     * 姓名
     */
    String name;
    /**
     * 生日
     */
    LocalDate birthday;
    /**
     * 性别
     */
    Sex gender;
    /**
     * 邮箱
     */
    String emailAddress;
    /**
     * 年龄
     */
    Integer age;

    /**
     * 输出
     */
    public void printPerson() {
        System.out.println("大家好");
    }
}