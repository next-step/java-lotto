package calculator.domain;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Operands {

    private final List<Integer> operands;

    Operands(String... operands) {
        validate(operands);

        this.operands = Arrays.stream(operands)
                .map(this::toInt)
                .collect(Collectors.toUnmodifiableList());
    }

    private void validate(String[] operands) {
        if (operands == null || operands.length == 0) {
            throw new IllegalArgumentException("피연산자를 입력해 주세요.");
        }
    }

    private int toInt(String input) {
        try {
            return Integer.parseInt(input);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해 주세요.");
        }
    }

    Iterator<Integer> iterator() {
        return operands.iterator();
    }
}
