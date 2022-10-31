package calculator;

import operator.Operator;

import java.util.*;
import java.util.stream.*;

public class Calculator {

    public int calculate(String input) {
        List<String> values = initValues(input);

        while (values.size() != 1) {
            initAndCalculate(values);
        }

        return Integer.parseInt(values.get(0));
    }

    private List<String> initValues(String input) {
        inputEmptyCheck(input);

        List<String> values = Stream.of(input.split(" "))
                .collect(Collectors.toCollection(ArrayList::new));
        return values;
    }

    private void inputEmptyCheck(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력 문자열이 빈 값 입니다.");
        }
    }

    private void initAndCalculate(List<String> values) {
        int result = Operator.calculate(Integer.parseInt(values.remove(0)), values.remove(0), Integer.parseInt(values.remove(0)));

        values.add(0, String.valueOf(result));
    }
}
