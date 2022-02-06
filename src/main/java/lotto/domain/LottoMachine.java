package lotto.domain;

import java.util.List;

public class LottoMachine {

    private final List<Integer> winningNumbers;
    private final int bonusNumber;
    private final int LOTTO_LENGTH = 6;

    public LottoMachine(List<Integer> winNumbers, int bonusNumber) {
        this.winNumbers = winNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void checkLengthOfWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 숫자 6개를 입력해주세요");
        }
    }


    public boolean isContain(int number) {
        return winNumbers.contains(number);
    }

    public boolean isEqualBonusNumber(final int number) {
        return bonusNumber.equals(number);
    }


}
