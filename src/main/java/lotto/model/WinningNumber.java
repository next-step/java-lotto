package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

public class WinningNumber {

    private static final String BONUS_BALL_EXISTS_IN_WINNING_NUMBERS = "보너스볼이 이미 당첨번호에 있습니다";
    private static final int ZERO = 0;

    private final Lotto winningNumbers;
    private final LottoNumber bonusBall;

    public WinningNumber(List<Integer> winningNumbers, int bonusBall) {
        this.winningNumbers = new Lotto(
            winningNumbers.stream().map(LottoNumber::new).collect(Collectors.toList()));
        isBonusBallInWinningNumbers();
        this.bonusBall = new LottoNumber(bonusBall);
    }

    private void isBonusBallInWinningNumbers() {
        if (isContainBonusBall(this.winningNumbers.getLottoNumbers())) {
            throw new IllegalArgumentException(BONUS_BALL_EXISTS_IN_WINNING_NUMBERS);
        }
    }

    public int findMatchingCount(List<LottoNumber> lotto) {
        int matchingResult = ZERO;
        for (LottoNumber winningNumber : winningNumbers.getLottoNumbers()) {
            matchingResult = countMatchingNumber(winningNumber, matchingResult, lotto);
        }
        return matchingResult;
    }

    private int countMatchingNumber(LottoNumber winningNumber, int count, List<LottoNumber> lotto) {
        if (lotto.contains(winningNumber)) {
            count++;
        }
        return count;
    }

    public boolean isContainBonusBall(List<LottoNumber> lotto) {
        return lotto.contains(bonusBall);
    }
}
