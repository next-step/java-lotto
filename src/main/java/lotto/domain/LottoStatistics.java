package lotto.domain;

import java.math.BigDecimal;
import java.util.List;

public class LottoStatistics {

    private final List<Rank> lottoStatistics;

    public LottoStatistics(List<Rank> lottoStatistics) {
        this.lottoStatistics = lottoStatistics;
    }

    public String getLottoEarningRate(LottoPrice lottoPrice) {
        int totalPrice = 0;
        for (Rank statistics : lottoStatistics) {
            totalPrice += statistics.getMoney();
        }
        return String.format("%.2f", BigDecimal.valueOf(totalPrice).divide(
            BigDecimal.valueOf(lottoPrice.getPrice())));
    }

    public List<Rank> getLottoStatistics() {
        return lottoStatistics;
    }

}
