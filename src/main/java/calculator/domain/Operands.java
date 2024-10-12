package calculator.domain;

import calculator.util.StringUtil;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Operands {

    private final List<Integer> operands;

    Operands(String... operands) {
        validate(operands);

        this.operands = Arrays.stream(operands)
                .map(StringUtil::toInt)
                .collect(Collectors.toUnmodifiableList());
    }

    private void validate(String[] operands) {
        if (StringUtil.isEmpty(operands)) {
            throw new IllegalArgumentException("피연산자를 입력해 주세요.");
        }
    }

    Iterator<Integer> iterator() {
        return operands.iterator();
    }
}
