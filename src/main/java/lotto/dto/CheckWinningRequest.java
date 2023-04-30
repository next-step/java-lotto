package lotto.dto;

import java.util.List;

public class CheckWinningRequest {
    private List<Integer> winningNumbers;

    public CheckWinningRequest(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }


}
