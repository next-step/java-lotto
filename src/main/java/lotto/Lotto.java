package lotto;

import java.util.List;

public class Lotto {
    public Lotto(List<Integer> numbers) {
        if (numbers.stream().anyMatch(i -> i <= 0 || 45 < i) || numbers.size() != 6
                || numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException("올바르지 않은 입력 입니다.");
        }
    }
}
