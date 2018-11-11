package raffle.lotto.money;

import raffle.lotto.win.WinLotto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import static com.sun.webkit.graphics.GraphicsDecoder.SCALE;

public class Money {
    private int money;

    private List<WinLotto> winLottos;

    public Money(int money, List<WinLotto> winLottos){
        this.money = money;
        this.winLottos = winLottos;
    }

    public double getCalculateProfit() {
        int totalMoney = winLottos.stream().mapToInt(WinLotto::getPrice).sum();
        double profit = (double) totalMoney / money;
        return new BigDecimal(profit)
                .setScale(SCALE, RoundingMode.HALF_UP)
                .doubleValue();
    }
}
