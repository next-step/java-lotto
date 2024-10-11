package calculator.domain;

import calculator.util.StringUtil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Operands {

    private List<Integer> operands;

    public Operands(String... operands) {
        validate(operands);

        this.operands = Arrays.stream(operands)
                .map(StringUtil::toInt)
                .collect(Collectors.toList());
    }

    private void validate(String[] operands) {
        if (StringUtil.isEmpty(operands)) {
            throw new IllegalArgumentException("피연산자를 입력해 주세요.");
        }
    }
}
