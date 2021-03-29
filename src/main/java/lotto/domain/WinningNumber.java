package lotto.domain;

import lotto.domain.enums.Rank;
import lotto.exception.LottoException;

import java.util.Objects;

public class WinningNumber {

    private static final String WINNING_NUMBER_CONTAIN_BONUS_NUMBER_ERROR = "당첨번호에 보너스번호가 올 수 없습니다.";
    private static final LottoGenerator lottoGenerator = LottoGenerator.getInstance();
    private final Lotto winningNumbers;
    private final int bonusNumber;

    private WinningNumber(final String winningNumbers, final int bonusNumber) {
        this.winningNumbers = Lotto.of(lottoGenerator.generateAppointedLotto(winningNumbers));
        this.bonusNumber = bonusNumber;
        validation();
    }

    public static WinningNumber of(final String winningNumbers, final int bonusNumber) {
        return new WinningNumber(winningNumbers, bonusNumber);
    }

    public Rank rankMatch(Lotto lotto) {
        boolean bonusMatch = lotto.containBonusNumber(bonusNumber);
        long matchCount = winningNumbers.matchCount(lotto);
        return Rank.of(matchCount, bonusMatch);
    }

    private void validation() {
        if (winningNumbers.containBonusNumber(bonusNumber)) {
            throw new LottoException(WINNING_NUMBER_CONTAIN_BONUS_NUMBER_ERROR);
        }
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        WinningNumber winningNumber = (WinningNumber) object;
        return bonusNumber == winningNumber.bonusNumber && Objects.equals(winningNumbers, winningNumber.winningNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningNumbers, bonusNumber);
    }
}
