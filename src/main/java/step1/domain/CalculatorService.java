package step1.domain;

import step1.dto.CalculateRequestDto;

public class CalculatorService {

    private final Calculator calculator = new Calculator();

    public int calculateValues(CalculateRequestDto requestDto) {
        String[] values = requestDto.getValues();
        int result = Integer.parseInt(values[0]);

        for (int i = 1; i < values.length; i += 2) {
            String operator = values[i];
            int nextValue = Integer.parseInt(values[i + 1]);
            result = calculate(result, operator, nextValue);
        }
        return result;
    }

    private int calculate(int first, String operator, int second) {
        if (operator.equals("+"))
            return calculator.add(first, second);
        if (operator.equals("-"))
            return calculator.subtract(first, second);
        if (operator.equals("*"))
            return calculator.multiply(first, second);
        if (operator.equals("/"))
            return calculator.divide(first, second);
        throw new IllegalArgumentException("연산자 오류");
    }
}
