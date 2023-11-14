package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringCalculator {

    private List<String> input;
    private Calculator calculator;

    public StringCalculator(List<String> input) {
        this.input = input;
    }

    private static Map<String, Calculator> getStringCalculatorMap() {
        Map<String, Calculator> operatorMap = new HashMap<>();
        operatorMap.put("+", new Addition());
        operatorMap.put("-", new Subtraction());
        operatorMap.put("*", new Multiplication());
        operatorMap.put("/", new Division());
        return operatorMap;
    }

    private static String checkOperator(String operator) {
        if (!"+".equals(operator) && !"-".equals(operator) && !"*".equals(operator) && !"/".equals(operator)) {
            throw new IllegalArgumentException("사칙연산 기호는 +, -, *, / 만 가능합니다.");
        }
        return operator;
    }

    public int calculator() {
        Map<String, Calculator> operatorMap = getStringCalculatorMap();
        try {
            int result = Integer.parseInt(input.get(0));
            for (int i = 1; i < input.size() - 1; i += 2) {
                calculator = operatorMap.get(checkOperator(input.get(i)));
                result = calculator.calculator(result, Integer.parseInt(input.get(i + 1)));
            }
            return result;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해 주세요.");
        }
    }
}
