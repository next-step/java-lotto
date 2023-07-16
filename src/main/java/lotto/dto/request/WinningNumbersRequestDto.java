package lotto.dto.request;

import java.util.List;

public class WinningNumbersRequestDto {

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningNumbersRequestDto(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
