package lotto.domain;

import java.util.List;

public class LottoStatistics {

    public String getLottoEarningRate(List<Rank> resultStatistics, LottoPrice lottoPrice) {
        double totalPrice = 0;
        for (Rank statistics : resultStatistics) {
            totalPrice += statistics.getMoney();
        }
        return String.format("%.2f", totalPrice / lottoPrice.getPrice());
    }

}
