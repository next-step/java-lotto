package stringcalculator;

public class Calculator {

    public static String[] inputSpilt(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력 값이 없습니다.");
        }
        return input.split(" ");
    }
}
