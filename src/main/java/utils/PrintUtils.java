package utils;

import java.text.MessageFormat;

public interface PrintUtils {

    static void printSpace() {
        System.out.println();
    }

    static void print(String message) {
        System.out.println(message);
    }

    static void print(String pattern, Object... arguments) {
        System.out.println(MessageFormat.format(pattern, arguments));
    }

}
