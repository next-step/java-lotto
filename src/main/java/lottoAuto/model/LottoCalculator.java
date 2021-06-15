package lottoAuto.model;

import java.math.BigDecimal;
import java.util.Map;

public class LottoCalculator {
    private static final int LOTTO_PRICE = 1000;
    private static final String CHECK_LOTTO_PRICE_MESSAGE = "로또 1장의 가격은 1000원입니다.";

    public int calculateAmount(int price) {
        checkLottoPrice(price);
        return price / LOTTO_PRICE;
    }

    private void checkLottoPrice(int price) {
        if (price < LOTTO_PRICE) {
            throw new IllegalArgumentException(CHECK_LOTTO_PRICE_MESSAGE);
        }
    }

    public BigDecimal getRevenue(int price, Map<Rank, Long> resultMap) {
        int sum = resultMap.entrySet().stream()
                .mapToInt(rankLongEntry -> Rank.calculatePrize(rankLongEntry.getKey(), rankLongEntry.getValue()))
                .sum();

        return BigDecimal.valueOf(sum).divide(BigDecimal.valueOf(price));
    }
}
