package study;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SplitExpression {
    private List<Integer> numbers;

    public SplitExpression(String expression) {
        this.numbers = Arrays.stream(SplitUtil.splitExpression(expression))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int sum() {
        int result = 0;

        for (Integer number : numbers) {
            this.validateNegative(number);
            result += number;
        }

        return result;
    }

    private void validateNegative(int number) {
        if (number < 0) {
            throw new RuntimeException("음수값은 입력할 수 없습니다.");
        }
    }
}
