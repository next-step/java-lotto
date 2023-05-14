package lotto.domain;

import java.util.Arrays;
import java.util.List;

import static lotto.utils.LottoNumberValidationUtils.*;
import static lotto.utils.LottoNumbersValidationUtils.validateLottoNumbers;

public class WinningLotto {

    private final List<Integer> winningNumbers;
    private final int bonusLottoNumber;

    public WinningLotto(List<Integer> winningNumbers, int bonusLottoNumber) {
        validateLottoNumbers(winningNumbers);
        isLottoCandidateNumber(bonusLottoNumber);
        this.winningNumbers = winningNumbers;
        this.bonusLottoNumber = bonusLottoNumber;
    }

    public Rank calculateRank(Lotto lotto) {
        return findRank(this.getMatchNumbers(lotto), hasBonusNumber(lotto));
    }

    public Rank findRank(int winningCount, boolean hasBonusNumber) {
        if (isSecondPlace(winningCount, hasBonusNumber)) {
            return Rank.SECOND_PLACE;
        }
        if (isThirdPlace(winningCount, hasBonusNumber)) {
            return Rank.THIRD_PLACE;
        }
        return findCertainPlace(winningCount);
    }

    private Rank findCertainPlace(int winningCount) {
        return Arrays.stream(Rank.values())
                .filter(rank -> isWinningCount(winningCount, rank))
                .findFirst()
                .orElse(Rank.LOST);
    }

    private static boolean isThirdPlace(int winningCount, boolean hasBonusNumber) {
        return winningCount == Rank.THIRD_PLACE.getWinningCount() && !hasBonusNumber;
    }

    private static boolean isSecondPlace(int winningCount, boolean hasBonusNumber) {
        return winningCount == Rank.SECOND_PLACE.getWinningCount() && hasBonusNumber;
    }

    public boolean isWinningCount(int winningCount, Rank rank) {
        return rank.getWinningCount() == winningCount;
    }

    public int getMatchNumbers(Lotto lotto) {
        return (int) lotto.getLottoNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public boolean hasBonusNumber(Lotto lotto) {
        return lotto.getLottoNumbers().contains(bonusLottoNumber);
    }
}
