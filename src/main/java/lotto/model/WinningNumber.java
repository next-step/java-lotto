package lotto.model;

import java.util.Arrays;
import java.util.stream.Collectors;

public class WinningNumber {

    private final Lotto lotto;
    private final Number bonusNumber;

    public WinningNumber(Lotto lotto, Number bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinningNumber from(String[] winningNumber, Number bonusNumber) {
        return new WinningNumber(makeLotto(winningNumber), bonusNumber);
    }

    private static Lotto makeLotto(String[] winningNumber) {
        return new Lotto(Arrays.stream(winningNumber)
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
