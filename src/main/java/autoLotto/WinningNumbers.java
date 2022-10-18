package autoLotto;

import java.util.List;

public class WinningNumbers {

    private List<Integer> winningNumbers;

    public WinningNumbers(final List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("당첨 숫자는 6개 입력 해야합니다.");
        }

        for (Integer number : winningNumbers) {
            if (number > 45) {
                throw new IllegalArgumentException("당청 숫자는 1 ~ 45만 입력 가능합니다.");
            }
        }
        this.winningNumbers = winningNumbers;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
