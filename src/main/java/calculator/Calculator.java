package calculator;

public class Calculator {

    private static final String INPUT_VALUE_EXCEPTION_MESSAGE = "입력값은 null 혹은 빈 공백 문자일수 없습니다.";

    public static void inputValidate(String input) {

        if(input == null || input.isBlank()) {
            throw new IllegalArgumentException(INPUT_VALUE_EXCEPTION_MESSAGE);
        }


    }


}
