package lottoauto;

import java.util.ArrayList;
import java.util.Arrays;
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

    public int checkWinning(LottoTicket lottoTicket) {
        int result = 0;

        for(int number: winningNumber) {
            if(lottoTicket.contains(number)) {
                result++;
            }
        }

        return result;
    }
}
