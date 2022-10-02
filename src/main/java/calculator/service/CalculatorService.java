package calculator.service;

import calculator.domain.Calculator;
import calculator.util.StringUtils;

/**
 * Created by seungwoo.song on 2022-09-27
 */
public class CalculatorService {

    public static final String SEPARATOR = " ";
    private final Calculator calculator;

    public CalculatorService(Calculator calculator) {
        this.calculator = calculator;
    }

    public int calculate(String text) {
        validateInput(text);
        String[] tokens = text.split(SEPARATOR);

        for (String token : tokens) {
            calculator.calculate(token);
        }

        return calculator.getResult();
    }

    private void validateInput(String text) {
        if (StringUtils.isBlank(text)) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }
    }
}
