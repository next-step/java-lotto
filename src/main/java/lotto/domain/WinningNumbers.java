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
            throw new IllegalArgumentException("[ERROR] 당첨번호는 6개를 입력해야 합니다.");
        }
        ballNumbers.forEach(this::validateRange);
    }

    private void validateRange(int bonusBall) {
        if (bonusBall > MAX_NUMBER || bonusBall < MIN_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 당첨번호는 1~45 사이의 숫자여야 합니다.");
        }
    }

    public int compareLottoNumbers(LottoNumbers lottoNumbers) {
        return lottoNumbers.getMatchCount(this.ballNumbers);
    }

    public boolean checkBonusBall(LottoNumbers lottoNumbers) {
        return lottoNumbers.contains(bonusBall);
    }

}
