package lotto.domain.summary;

import java.util.Objects;

public class Summary {

    public static final String PROFIT_RATE_MESSAGE = "총 수익률은 %,.3f입니다.";

    private final WinningSummary winningSummary;
    private final ProfitRate profitRate;

    private Summary(WinningSummary winningSummary, Long purchasePrice) {
        this.winningSummary = winningSummary;
        this.profitRate = ProfitRate.of(winningSummary, purchasePrice);
    }

    public static Summary of(WinningSummary winningSummary, Long purchasePrice) {
        return new Summary(winningSummary, purchasePrice);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Summary summary = (Summary) o;
        return Objects.equals(winningSummary, summary.winningSummary) && Objects.equals(profitRate, summary.profitRate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningSummary, profitRate);
    }

    @Override
    public String toString() {
        StringBuilder stringBuffer = new StringBuilder();
        stringBuffer.append(winningSummary);
        stringBuffer.append(String.format(PROFIT_RATE_MESSAGE, profitRate.value()));

        return stringBuffer.toString();
    }
}
