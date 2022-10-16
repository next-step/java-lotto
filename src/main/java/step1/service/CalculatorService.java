package step1.service;

import step1.domain.Operator;

import java.util.List;

public class CalculatorService {

    private static final int CALCULATE_TARGET_SET = 2;

    public static int calculate(List<String> input) {
        int firstNum = convertInteger(input.get(0));
        for (int i = 1; i < input.size(); i+=CALCULATE_TARGET_SET) {
            String operator = input.get(i);
            int secondNum = convertInteger(input.get(i + 1));
            firstNum = Operator.calculate(firstNum, operator, secondNum);
        }
        return firstNum;
    }

    private static int convertInteger(String value) {
        try {
            return validation(Integer.parseInt(value));
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자만 입력해 주세요");
        }
    }

    private static int validation(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("음수는 지원하지 않습니다.");
        }
        return value;
    }
}
