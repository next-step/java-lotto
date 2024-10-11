package domain;

import exception.WrongCalculationException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {
    private List<Integer> numbers = new ArrayList<Integer>();
    private List<Operator> operators = new ArrayList<Operator>();
    private static final String DELIMITER = " ";

    public int calculate(String input) throws WrongCalculationException {
        splitTokens(Arrays.asList(input.split(DELIMITER)));
        validatePreparationForCalculation();
        return calculate();
    }

    private void validatePreparationForCalculation() throws WrongCalculationException {
        if (numbers.size() != operators.size() + 1) {
            throw new WrongCalculationException("잘못된 계산식입니다. 숫자 길이 : " + numbers.size() + ", 기호 길이 : " + operators.size());
        }
    }

    private int calculate() {
        int result = numbers.get(0);

        for (int i = 0; i < operators.size(); i++) {
            Operator operator = operators.get(i);
            result = operator.calculate(result, numbers.get(i + 1));
        }

        return result;
    }

    private void splitTokens(List<String> tokens) {
        for (int i = 0; i < tokens.size(); i++) {
            if (isEven(i)) {
                numbers.add(convertToInteger(tokens.get(i)));
            }

            if (isOdd(i)) {
                operators.add(Operator.getInstance(tokens.get(i)));
            }
        }
    }

    private Integer convertToInteger(String s) {
        try {
            return Integer.parseInt(s);
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자로 변환할 수 없는 문자입니다.");
        }
    }

    private boolean isEven(int i) {
        return i % 2 == 0;
    }

    private boolean isOdd(int i) {
        return i % 2 == 1;
    }
}
