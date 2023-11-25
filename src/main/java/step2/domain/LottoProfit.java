package step2.domain;

import java.util.Arrays;
import java.util.Map;

public class LottoProfit {

    private final Map<LottoRank, Integer> result;

    public LottoProfit(Map<LottoRank, Integer> result) {
        this.result = result;
    }

    public double profit(int ticketMoney) {
        return totalPrize() / ticketMoney;
    }

    private double totalPrize() {
        return Arrays.stream(LottoRank.VALUES).map(lottoRank -> result.get(lottoRank)*lottoRank.reward()).reduce(Integer::sum).orElse(0);
    }
}
