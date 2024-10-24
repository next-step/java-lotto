package lotto;

import java.util.List;

public class Lotto {
    public Lotto(List<Integer> numbers) {
        if (numbers.stream().anyMatch(i -> i <= 0 || 45 < i)) {
            throw new IllegalArgumentException("로또는 1에서 45사이의 값이여야 합니다.");
        }
    }
}
