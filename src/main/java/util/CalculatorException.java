package util;

public class CalculatorException {

    public static void validateMinus(String text) {
        if(text.contains("-")) {
            throw new RuntimeException("음수는 입력 받을 수 없습니다.");
        }
    }

}
