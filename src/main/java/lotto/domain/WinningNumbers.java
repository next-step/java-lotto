package lotto.domain;

import java.util.List;

public class WinningNumbers {
    private static final int NUMBER_OF_WINNING_NUM = 6;
    private static final int LOTTO_MAXIMUM_NUMBER = 45;
    private static final int LOTTO_MIN_NUMBER = 1;

    private List<Integer> winningNumbers;
    private int bonusNumber;

    public WinningNumbers(final List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.size() != NUMBER_OF_WINNING_NUM) {
            throw new IllegalArgumentException("당첨 숫자는 6개 입력 해야합니다.");
        }

        for (Integer winningNumber : winningNumbers) {
            checkNumbers(winningNumber);
        }
        checkNumbers(bonusNumber);

        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void checkNumbers(Integer number) {
        if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAXIMUM_NUMBER) {
            throw new IllegalArgumentException("당청 숫자는 1 ~ 45만 입력 가능합니다.");
        }
    }

    public List<Integer> numbers() {
        return winningNumbers;
    }

    public int bonusNumber() {
        return bonusNumber;
    }
}
