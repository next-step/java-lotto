package step1.service;

import step1.utils.StringUtils;

import java.util.Arrays;
import java.util.Iterator;

public class OperatorService {

    private static final String DELIMITER = " ";

    public int operate(final String input) {
        String[] split = input.split(DELIMITER);
        int operatedNumber = 0;
        for (int i = 0; i < split.length; i+=2) {
            validate(split[i]);
            operatedNumber = operation(i, split, operatedNumber);
        }
        return operatedNumber;
    }

    private void validate(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException("유효한 입력값이 아닙니다.");
        }
    }

    private int operation(int index, String[] split, int operatedNumber) {
        if (index == 0) {
            return Integer.parseInt(split[index]);
        }
        return Operator.of(split[index-1]).calculate(operatedNumber, Integer.parseInt(split[index]));
    }
}
