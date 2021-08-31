package lotto.domain;

import java.util.List;
import java.util.Objects;

public class WinningNumber {
    private static final String EXCEP_INVALID_WINNING_NUMBER = "적합한 당첨번호가 아닙니다.";
    private final Lotto winningNumber;
    private final LottoNumber bonusNumber;

    public WinningNumber(List<Integer> winningNumber, int bonusNumber) {
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(EXCEP_INVALID_WINNING_NUMBER);
        }
        this.winningNumber = new Lotto(winningNumber);
        this.bonusNumber = LottoNumber.of(bonusNumber);
    }

//    void checkValidWinningNumber(Lotto winningNumber, LottoNumber bonusNumber) {
//        if (winningNumber.contains(bonusNumber)) {
//            throw new IllegalArgumentException()
//        }
//    }

//    public Prize checkLottoPrize(Lotto lotto) {
//
//    }

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
