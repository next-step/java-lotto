package lottoauto;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {
    private List<Integer> winningNumber;

    public WinningNumber(List<Integer> winningNumber) {
        this.winningNumber = winningNumber;
    }

    public WinningNumber(String winningNumberStr) {
        winningNumber = new ArrayList<>();

        for(String str: winningNumberStr.split(",")) {
            Integer num = Integer.parseInt(str.trim());
            winningNumber.add(num);
        }
    }

    public void checkWinning(LottoTicket lottoTicket) {
        lottoTicket.checkWinning(winningNumber);
    }
}
