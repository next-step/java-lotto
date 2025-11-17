package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    public static int calculate(String input) {
        if (isBlankOrNull(input)) {
            throw new IllegalArgumentException("입력 값은 필수입니다.(공백은 입력할 수 없습니다.)");
        }

        String[] splitInput = input.split(" ");

        List<Operator> operators = splitOperator(splitInput);

        return 0;
    }

    private static List<Operator> splitOperator(String[] values) {
        List<Operator> operators = new ArrayList<>();
        for (String value : values) {
            if(!isNumber(value)){
                operators.add(Operator.fromName(value));
            }
        }
        return operators;
    }

    private static boolean isNumber(String value) {
        return value.matches("^[0-9]+$");
    }


    private static boolean isBlankOrNull(String input) {
        return input == null || input.isBlank();
    }


    public static int plus(TargetNumber targetNumber) {
        return targetNumber.plus();
    }

    public static int minus(TargetNumber targetNumber) {
        return targetNumber.minus();
    }

    public static int multiplication(TargetNumber targetNumber) {
        return targetNumber.multiplication();
    }

    public static int division(TargetNumber targetNumber) {
        return targetNumber.division();
    }
}
