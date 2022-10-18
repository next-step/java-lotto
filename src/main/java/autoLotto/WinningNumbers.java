package autoLotto;

import java.util.List;

public class WinningNumbers {
    private static final int NUMBER_OF_WINNING_NUM = 6;
    private static final int MAXIMUM_NUMBER = 45;

    private List<Integer> winningNumbers;

    public WinningNumbers(final List<Integer> winningNumbers) {
        if (winningNumbers.size() != NUMBER_OF_WINNING_NUM) {
            throw new IllegalArgumentException("당첨 숫자는 6개 입력 해야합니다.");
        }

        winningNumbers.forEach(n -> checkMaxNum(n));

        this.winningNumbers = winningNumbers;
    }

    private void checkMaxNum(Integer number) {
        if (number > MAXIMUM_NUMBER) {
            throw new IllegalArgumentException("당청 숫자는 1 ~ 45만 입력 가능합니다.");
        }
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
