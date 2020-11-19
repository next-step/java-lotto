package lotto.domain.winning;

import lotto.domain.game.Lotto;

import java.util.List;

/**
 * Created By mand2 on 2020-11-19.
 * 당첨번호와 내 로또번호가 얼마나 맞는지 확인.
 */
public class WinningChecker {

    private final List<Integer> winningNumbers;

    private WinningChecker(WinningNumber winningNumber) {
        this.winningNumbers = winningNumber.value();
    }

    public static WinningChecker of(WinningNumber winningNumber) {
        return new WinningChecker(winningNumber);
    }

    public long compare(Lotto lotto) {
        return lotto.number().stream()
                .filter(num -> this.winningNumbers.contains(num))
                .count();
    }

}
