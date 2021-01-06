package util;

public class CommonException {

    public static void RuntimeException(String message) {
        throw new RuntimeException(message);
    }
    public static void IllegalArgumentException(String message) {
        throw new IllegalArgumentException(message);
    }
    public static void NumberOverlapException(String message) {
        throw new RuntimeException(message);
    }
}
