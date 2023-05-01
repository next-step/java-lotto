package step2.utils;

public class Validation {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private Validation(){}

    public static void validate(int number) {
        if (isValidNumber(number)){
           throw new IllegalArgumentException("유효하지 않은 숫자입니다.");
        }
    }

    private static boolean isValidNumber(int number) {
        return number < MIN_NUMBER || number > MAX_NUMBER;
    }
}
