package lotto.domain;

import java.util.List;
import java.util.Objects;

public class WinningNumber {
    private static final String EXCEP_INVALID_WINNING_NUMBER = "적합한 당첨번호가 아닙니다.";
    private final Lotto winningNumber;
    private final LottoNumber bonusNumber;

    public WinningNumber(List<Integer> winningNumber, int bonusNumber) {
        checkValidWinningNumber(winningNumber, bonusNumber);
        this.winningNumber = new Lotto(winningNumber);
        this.bonusNumber = LottoNumber.of(bonusNumber);
    }

    private void checkValidWinningNumber(List<Integer> winningNumber, int bonusNumber) {
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(EXCEP_INVALID_WINNING_NUMBER);
        }
    }

    public Prize checkLottoPrize(Lotto lotto) {
        boolean matchOfBonus = isMatchingBonus(lotto);
        int matchingNumberCount = lotto.countMatchingNums(winningNumber);

        return Prize.valueOf(matchingNumberCount, matchOfBonus);
    }

    public boolean isMatchingBonus(Lotto lotto) {
        return lotto.contains(bonusNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningNumber that = (WinningNumber) o;
        return Objects.equals(winningNumber, that.winningNumber) && Objects.equals(bonusNumber, that.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningNumber, bonusNumber);
    }

}
