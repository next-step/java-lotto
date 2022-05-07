package calculator.domain;

import java.util.Arrays;
import java.util.List;

public class CalculateInput {
    private static final int START_VALUE = 1;
    private static final int INCREASE_VALUE = 2;

    private final String inputData;

    public CalculateInput(String inputData) {
        if (inputData == null || inputData.isBlank()) {
            throw new IllegalArgumentException("빈 값을 입력할 수 없습니다.");
        }
        this.inputData = inputData;
    }

    public int splitAndCalculate() {
        List<String> calculateData = split();

        int result = 0;
        for (int index = START_VALUE; index < calculateData.size(); index += INCREASE_VALUE) {
            result = calculate(calculateData, result, index);
        }
        return result;
    }

    private List<String> split() {
        String[] splitData = inputData.split(" ");
        if (splitData.length < 3) {
            throw new IllegalArgumentException("계산하기 위해서는 최소 두개의 값과 한개의 연산 기호가 필요합니다.");
        }
        return Arrays.asList(splitData);
    }

    private int calculate(List<String> calculateData, int result, int index) {
        if (START_VALUE == index) {
            result = Integer.parseInt(calculateData.get(0));
        }

        Calculator calculator = new Calculator(result, calculateData.get(index), calculateData.get(index + 1));
        return calculator.calculate();
    }
}
