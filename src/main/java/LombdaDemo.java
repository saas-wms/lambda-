import java.util.List;

/**
 * 〈功能简述〉<br/>
 * 〈lombda的测试类〉
 *
 * @author lzy
 * @date 2018/5/3
 * @since 1.0.0
 */
public class LombdaDemo {
    interface CheckPerson {
        boolean test(Person p);
    }

    class CheckPersonEligibleForSelectiveService implements CheckPerson {
        @Override
        public boolean test(Person p) {
            return p.gender == Person.Sex.MALE &&
                    p.getAge() >= 18 &&
                    p.getAge() <= 25;
        }
    }

    public static void printPersonsOlderThan(List<Person> roster, int age) {
        for (Person p : roster) {
            if (p.getAge() >= age) {
                p.printPerson();
            }
        }
    }

    public static void printPersonsWithinAgeRange(
            List<Person> roster, int low, int high) {
        for (Person p : roster) {
            if (low <= p.getAge() && p.getAge() < high) {
                p.printPerson();
            }
        }
    }

    public static void printPersons(List<Person> roster) {
        for (Person p : roster) {
            CheckPerson checkPerson = new CheckPerson() {
                @Override
                public boolean test(Person p) {
                    return p.gender == Person.Sex.MALE &&
                            p.getAge() >= 18 &&
                            p.getAge() <= 25;
                }
            };

            if (checkPerson.test(p)) {
                p.printPerson();
            }

        }
    }

    public static void printPersons1(List<Person> roster, CheckPerson checkPerson) {
        roster.forEach(p -> {
            if (checkPerson.test(p)) {
                p.printPerson();
            }
        });
    }



}