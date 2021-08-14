package Lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WinningResult {

    private List<WinningPrice> winningPrice = new ArrayList<>();

    public static final double FLOOR_NUMBER = 100.0;


    public WinningResult(List<WinningPrice> winningPrice) {
        this.winningPrice = winningPrice;
    }

    public static WinningResult of(List<WinningPrice> winningPrice) {
        return new WinningResult(winningPrice);
    }

    public StringBuffer getWinningResult() {
        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append("\n당첨 통계\n" + "---------\n");
        Arrays.stream(WinningPrice.values()).filter(winning -> winning != WinningPrice.NOT_WINNINGS)
                .forEach(winning ->
                        stringBuffer.append(winning.match + ((winning == WinningPrice.FIVE_WINNINGS_BOBUS) ? "개 일치, 보너스 볼 일치" + "(" : "개 일치" + "(")
                                + winning.price + "원)"
                                + "-" + Collections.frequency(this.winningPrice, winning)
                                + "개\n"));

        return stringBuffer;
    }

    public double yieldAccount(double money) {

        return Math.floor((this.winningPrice.stream()
                .mapToInt(winning -> winning.price * Collections.frequency(this.winningPrice, winning))
                .sum() / money) * FLOOR_NUMBER) / FLOOR_NUMBER;

    }
}
