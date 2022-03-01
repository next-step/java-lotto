package calculator.domain;

import java.util.List;

public class StringCalculator {

    private static final int RESULT_FOR_EMPTY = 0;
    private final int result;

    public StringCalculator(List<Integer> numbers) {
        validateNegative(numbers);
        this.result = createResult(numbers);
    }

    private int createResult(List<Integer> numbers)  {
        if(numbers.isEmpty()) {
            return RESULT_FOR_EMPTY;
        }
        return numbers.stream().mapToInt(number -> number).sum();
    }

    private void validateNegative(List<Integer> tokenized) {
        if(tokenized.stream().anyMatch(number -> number < 0)) {
            throw new IllegalArgumentException("[ERROR] 음수는 입력할 수 없습니다.");
        }
        tokenized.clear();
        System.out.println(tokenized);
    }

    public int getResult() {
        return result;
    }
}
