package lotto;

import java.util.List;

public class Lotto {
    public Lotto(List<Integer> numbers) {
        if (hasInvalidNumber(numbers) || hasIncorrectSize(numbers) || hasDuplicates(numbers)) {
            throw new IllegalArgumentException("올바르지 않은 입력 입니다.");
        }
    }

    private boolean hasDuplicates(List<Integer> numbers) {
        return numbers.stream().distinct().count() != numbers.size();
    }

    private boolean hasIncorrectSize(List<Integer> numbers) {
        return numbers.size() != 6;
    }

    private boolean hasInvalidNumber(List<Integer> numbers) {
        return numbers.stream().anyMatch(i -> i < 1 || 45 < i);
    }
}
