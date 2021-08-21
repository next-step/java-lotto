package step2;

import java.util.ArrayList;
import java.util.List;

public class WinningResults {

    private List<Integer> winningNumbers = new ArrayList<>();

    public void saveWinningLottoNumber(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public List<Integer> getWinningLottoNumber() {
        return this.winningNumbers;
    }
}
