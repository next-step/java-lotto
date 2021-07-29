package lotto.domain.lotto;

import java.util.List;

public class WinningLotto extends Lotto {

    public WinningLotto(List<Integer> numbers) {
        super(numbers);
    }

    public int matchNumberCount(Lotto lotto) {
        return Math.toIntExact(lotto.numbers.stream()
            .filter(numbers::contains)
            .count());
    }
}
