package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {

    private final Lotto lotto;
    private final Number bonusNumber;

    public WinningLotto(Lotto lotto, Number bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto from(List<String> winningNumbers, Number bonusNumber) {
        return new WinningLotto(makeLotto(winningNumbers), bonusNumber);
    }

    private static Lotto makeLotto(List<String> winningNumbers) {
        return new Lotto(winningNumbers.stream()
                                       .map(Number::new)
                                       .collect(Collectors.toList()));
    }

    public int matchCount(Lotto target) {
        return lotto.matchCount(target);
    }

    public boolean hasBonusNumber(Lotto lotto) {
        return lotto.contains(bonusNumber);
    }
}
