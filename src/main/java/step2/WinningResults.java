package step2;

import java.util.HashMap;
import java.util.Map;

public class WinningResults {

    private Ticket winningNumbers;
    private Map<Integer, Integer> resultMap = new HashMap<>();

    public void saveWinningLottoNumber(Ticket winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public Ticket getWinningLottoNumber() {
        return this.winningNumbers;
    }
}
