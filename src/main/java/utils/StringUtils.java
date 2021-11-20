package utils;

public interface StringUtils {

    static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

}
