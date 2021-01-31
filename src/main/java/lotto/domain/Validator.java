package lotto.domain;

public class Validator {

    public static int checkIsIntegerAndIsNegative (String input) {
        try {
            int number = Integer.parseInt(input);
            isNegative(number);
            return number;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("입력된 수가 정수가 아닙니다.");
        }
    }

    public static void isNegative(int input) {
        if(input < 1) {
            throw new IllegalArgumentException("음수가 입력되었습니다.");
        }
    }


    public static void isInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("입력된 수가 정수가 아닙니다.");
        }
    }
}
