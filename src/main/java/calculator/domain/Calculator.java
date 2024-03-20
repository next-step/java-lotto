package calculator.domain;

import java.util.Arrays;
import java.util.OptionalInt;

import static calculator.domain.Operation.*;

public class Calculator {

    private static final String DELIMITER_POSITION = " ";
    private static final int START_NUMBER = 0;
    public static final String NULL_AND_EMPTY_VALIDATE  = "계산식을 입력해주세요";
    public static final String OPERATOR_VALIDATE  = "사칙연산 기호만 입력해주세요";
    public static final String NO_INSTANCE  = "유틸리티 클래스를 인스턴스화할 수 없습니다!";


    private Calculator() {
        throw new IllegalStateException(NO_INSTANCE);
    }

    public static int calculator(String rawString) {
        validate(rawString);
        String[] seperateString = split(rawString);
        int calculatingValue = setInitialValue(seperateString);
        return calculate(seperateString, calculatingValue);
    }

    private static void validate(String rawString) {
        if (rawString == null || rawString.isBlank()) {
            throw new IllegalArgumentException(NULL_AND_EMPTY_VALIDATE);
        }
    }
    private static int calculate(String[] seperateString, int calculatingValue) {
        for (int i = 1; i < seperateString.length-1; i+=2)
            calculatingValue = from(calculatingValue, seperateString[i], Integer.parseInt(seperateString[i + 1]));
        return calculatingValue;
    }

    private static int setInitialValue(String[] seperateString) {
        return Integer.parseInt(seperateString[START_NUMBER]);
    }

    private static String[] split(String rawString) {
        return rawString.split(DELIMITER_POSITION);
    }
}
