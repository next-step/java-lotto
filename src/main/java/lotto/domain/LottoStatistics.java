package lotto.domain;

import java.math.BigDecimal;
import java.util.List;

public class LottoStatistics {

    public String getLottoEarningRate(List<Rank> resultStatistics, LottoPrice lottoPrice) {
        int totalPrice = 0;
        for (Rank statistics : resultStatistics) {
            totalPrice += statistics.getMoney();
        }
        return String.format("%.2f", BigDecimal.valueOf(totalPrice).divide(
            BigDecimal.valueOf(lottoPrice.getPrice())));
    }

}
