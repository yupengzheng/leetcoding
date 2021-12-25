import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.Objects;

public class Test1 {

    public static void test(Class<?> cls) {
        for (Method m : cls.getDeclaredMethods()) {
            Annotation a = m.getAnnotation(Annotation.class);
            if (Objects.nonNull(a)) {
                String s = a.description();
                System.out.println(s);
            }
        }
    }


    public static void main(String[] args) {
        test(Test1.class);
    }

    @Annotation("nothing")
    public void test2() {

    }
}

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface Annotation {
    String value();
    String description() default "no description";
}
