import lombok.NonNull;

public class AnyTest {

    public static void test(@NonNull String message) {
        System.out.println(message);
    }

    public static void main(String[] args) {
        test(null);
    }
}
