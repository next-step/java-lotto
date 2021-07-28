package lotto.domain.lotto;

import java.util.List;

public class WinningLotto extends Lotto {

    public WinningLotto(List<Integer> numbers) {
        super(numbers);
    }

    public long matchNumberCount(Lotto lotto) {
        return lotto.numbers.stream()
            .filter(numbers::contains)
            .count();
    }
}
