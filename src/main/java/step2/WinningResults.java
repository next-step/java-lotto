package step2;

import java.util.ArrayList;
import java.util.List;

public class WinningResults {

    private LottoTicket winningNumbers;

    public void saveWinningLottoNumber(LottoTicket winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public LottoTicket getWinningLottoNumber() {
        return this.winningNumbers;
    }
}
