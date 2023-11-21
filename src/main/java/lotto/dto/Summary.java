package lotto.dto;

import lotto.constants.Winning;

import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;

public class Summary {

    public static final String PROFIT_RATE_MESSAGE = "총 수익률은 %f입니다.";

    private final WinningSummary winningSummary;
    private final float profitRate;

    public Summary(WinningSummary winningSummary, Long purchasePrice) {
        this.winningSummary = winningSummary;
        this.profitRate = profitRate(winningSummary.winnings(), purchasePrice);
    }


    private float profitRate(EnumMap<Winning, Long> winnings, long purchasePrice) {
        return (float) prizeTotal(winnings) / (float) purchasePrice;
    }

    private long prizeTotal(EnumMap<Winning, Long> winnings) {
        return winnings.entrySet().stream()
                .mapToLong(winning -> prizeTotalByWinning(winning))
                .sum();
    }

    private long prizeTotalByWinning(Map.Entry<Winning, Long> winning) {
        return winning.getKey().prize() * winning.getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Summary summary = (Summary) o;
        return Float.compare(profitRate, summary.profitRate) == 0 && Objects.equals(winningSummary, summary.winningSummary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningSummary, profitRate);
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(winningSummary);
        stringBuffer.append(String.format(PROFIT_RATE_MESSAGE, profitRate));

        return stringBuffer.toString();
    }
}
