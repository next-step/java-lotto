package lotto.domain;

import static lotto.util.Constant.*;

import java.util.List;

public class WinningNumbers {

    private final List<Integer> ballNumbers;
    private final int bonusBall;

    public WinningNumbers(List<Integer> winningNumbers, int bonusBall) {
        validateNumbers(winningNumbers);
        validateRange(bonusBall);
        this.ballNumbers = winningNumbers;
        this.bonusBall = bonusBall;
    }

    private void validateNumbers(List<Integer> ballNumbers) {
        if (ballNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(INVALID_SIZE);
        }
        ballNumbers.forEach(this::validateRange);
    }

    private void validateRange(int bonusBall) {
        if (bonusBall > MAX_NUMBER || bonusBall < MIN_NUMBER) {
            throw new IllegalArgumentException(INVALID_RANGE);
        }
    }

    public int compareLottoNumbers(LottoTicket lottoNumbers) {
        return lottoNumbers.getMatchCount(this.ballNumbers);
    }

    public boolean checkBonusBall(LottoTicket lottoNumbers) {
        return lottoNumbers.contains(bonusBall);
    }

    public LottoRank getRankForLottoTicket(LottoTicket ticket) {
        int count = compareLottoNumbers(ticket);
        boolean hasBonus = checkBonusBall(ticket);
        return LottoRank.valueOf(count, hasBonus);
    }
}
