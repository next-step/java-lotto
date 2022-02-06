package lotto.domain;

import java.util.List;

public class LottoMachine {

    private final List<Integer> winningNumbers;
    private final int bonusNumber;
    private final int LOTTO_LENGTH = 6;

    public LottoMachine(List<Integer> winningNumbers, int bonusNumber) {
        checkLengthOfWinningNumbers(winningNumbers);

        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void checkLengthOfWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 숫자 6개를 입력해주세요");
        }
    }


    public boolean isContain(int number) {
        return winningNumbers.contains(number);
    }

    public boolean isEqualBonusNumber(final int number) {
        return bonusNumber == number;
    }


}
