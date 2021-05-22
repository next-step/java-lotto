package lotto.domain;

import java.util.List;

public class WinningLotto extends Lotto {
    public final int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        this.bonusNumber = bonusNumber;
    }
}
