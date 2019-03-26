package util;

public class Console {
    public static void print(String message) {
        System.out.println(message);
    }

    public static void numberFormatExceptionMessage() {
        System.out.println("숫자가 아닙니다.");
    }

    public static void lottoRangeExceptionMessage() {
        System.out.println("로또 범위를 벗어났습니다.");
    }
}
