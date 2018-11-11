package raffle.lotto.money;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static com.sun.webkit.graphics.GraphicsDecoder.SCALE;
import static raffle.lotto.LottoMachine.LOTTO_PRICE;

public class Money {
    private int manualCount;
    private int amount;

    public Money(int manualCount, int amount){
        this.manualCount = manualCount;
        this.amount = amount;
    }

    public double getCalculateProfit(double profit) {
        return new BigDecimal(profit)
                .setScale(SCALE, RoundingMode.HALF_UP)
                .doubleValue();
    }

    public int getManualCount() {
        return manualCount;
    }

    public int getAmout() {
        return amount;
    }

    public int getRancomCount() {
        return (amount / LOTTO_PRICE) - manualCount;
    }
}
