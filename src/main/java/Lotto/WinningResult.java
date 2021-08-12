package Lotto;

import java.util.Collections;
import java.util.List;

public class WinningResult {

    List<WinningPrice> winningPrice;


    public WinningResult(List<WinningPrice> winningPrice) {
        this.winningPrice = winningPrice;
    }


    public StringBuffer getWinningResult() {
        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append("당첨 통계\n" + "---------\n");
        stringBuffer.append(WinningPrice.THREE_WINNINGS.match + "개 일치" + "(" + WinningPrice.THREE_WINNINGS.price + "원)" + "-" + Collections.frequency(winningPrice, WinningPrice.THREE_WINNINGS) + "개\n");
        stringBuffer.append(WinningPrice.FOUR_WINNINGS.match + "개 일치" + "(" + WinningPrice.FOUR_WINNINGS.price + "원)" + "-" + Collections.frequency(winningPrice, WinningPrice.FOUR_WINNINGS) + "개\n");
        stringBuffer.append(WinningPrice.FIVE_WINNINGS.match + "개 일치" + "(" + WinningPrice.FIVE_WINNINGS.price + "원)" + "-" + Collections.frequency(winningPrice, WinningPrice.FIVE_WINNINGS) + "개\n");
        stringBuffer.append(WinningPrice.SIX_WINNINGS.match + "개 일치" + "(" + WinningPrice.SIX_WINNINGS.price + "원)" + "-" + Collections.frequency(winningPrice, WinningPrice.SIX_WINNINGS) + "개\n");

        return stringBuffer;
    }

    public double yieldAccount(int money) {
        int total = WinningPrice.THREE_WINNINGS.price * Collections.frequency(winningPrice, WinningPrice.THREE_WINNINGS);
        total += WinningPrice.FOUR_WINNINGS.price * Collections.frequency(winningPrice, WinningPrice.FOUR_WINNINGS);
        total += WinningPrice.FIVE_WINNINGS.price * Collections.frequency(winningPrice, WinningPrice.FIVE_WINNINGS);
        total += WinningPrice.SIX_WINNINGS.price * Collections.frequency(winningPrice, WinningPrice.SIX_WINNINGS);

        return total / money;
    }
}
