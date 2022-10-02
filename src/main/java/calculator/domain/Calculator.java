package calculator.domain;

import calculator.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by seungwoo.song on 2022-09-27
 */
public class Calculator {
    private final CalculateResult calculateResult;

    public Calculator(CalculateResult calculateResult) {
        this.calculateResult = calculateResult;
    }

    public int calculate(String text) {
        validateInput(text);

        List<CalculateInfo> list = convert(text);
        for (CalculateInfo calculateInfo : list) {
            calculateInfo.calculate(calculateResult);
        }
        return calculateResult.result();
    }

    private void validateInput(String text) {
        if (StringUtils.isBlank(text)) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }
    }

    private List<CalculateInfo> convert(String text) {
        return Arrays.stream(text.split(" "))
                .map(token -> parse(token))
                .collect(Collectors.toList());
    }

    private CalculateInfo parse(String token) {
        if (Operator.isOperator(token)) {
            return new OpercatorValue(Operator.from(token));
        }

        return new NumberValue(Integer.valueOf(token));
    }
}
