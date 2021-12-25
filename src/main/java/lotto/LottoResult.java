package lotto;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoResult {
    private final Map<Rank, Integer> matchCount;

    public LottoResult(Map<Rank, Integer> matchCount) {
        this.matchCount = init(matchCount);
    }

    public Map<Rank, Integer> getWinnersLottoResult() {
        Map<Rank, Integer> winnersLottoResult = new HashMap<>();
        for(Rank winnerRank : Rank.LOTTO_WINS) {
            winnersLottoResult.put(winnerRank, matchCount.get(winnerRank));
        }
        return winnersLottoResult;
    }

    public BigDecimal calculateProfit(Money lottoUnitPrice) {
        Money winTotalMoney = new Money();
        Money spendMoney = new Money();

        for(Rank rank : matchCount.keySet()) {
            int count = matchCount.get(rank);

            winTotalMoney = winTotalMoney.add(rank.winPrice().multiply(count));
            spendMoney = spendMoney.add(lottoUnitPrice.multiply(count));
        }

        return winTotalMoney.calculateProfit(spendMoney);
    }

    private Map<Rank, Integer> init(Map<Rank, Integer> matchCounts) {
        Map<Rank, Integer> lottoResult = new HashMap<>();
        int defaultCount = 0;

        Arrays.asList(Rank.values()).forEach( rank -> lottoResult.put(rank, defaultCount));

        for(Rank rank : matchCounts.keySet()) {
            lottoResult.merge(rank, matchCounts.get(rank), Integer::sum);
        }

        return lottoResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        LottoResult that = (LottoResult) o;
        return Objects.equals(matchCount, that.matchCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchCount);
    }
}
