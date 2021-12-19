package lotto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos() {
        this(new ArrayList<>());
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int count() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return new ArrayList<>(lottos);
    }

    public Map<Integer, Integer> calculateMatchCount(Lotto winLotto) {
        Map<Integer, Integer> matchCounts = new HashMap<>();
        int defaultCount = 1;

        for (Lotto lotto : lottos) {
            int matchCount = lotto.countMatch(winLotto);
            matchCounts.merge(matchCount, defaultCount, Integer::sum);
        }

        return matchCounts;
    }

    public Map<Rank, Integer> calculateMatchCount(WinnerLotto winLotto) {
        Map<Rank, Integer> matchCounts = new HashMap<>();
        int increment = 1;

        for(Lotto lotto : lottos) {
            Rank rank = winLotto.calculateRank(lotto);
            matchCounts.merge(rank, increment, Integer::sum);
        }

        return matchCounts;
    }

    public BigDecimal calculateProfit(Lotto winnerLotto, Money lottoPrice) {
        Money totalWinPrice = new Money();

        for (Lotto lotto : lottos) {
            int matchCount = lotto.countMatch(winnerLotto);
            Money winPrice = Rank.winPriceOf(matchCount);
            totalWinPrice = totalWinPrice.add(winPrice);
        }

        return totalWinPrice.calculateProfit(moneyForLottos(lottoPrice));
    }

    public void addNewLotto(List<Number> numbers) {
        Lotto lotto = new Lotto(numbers);

        lottos.add(lotto);
    }

    private Money moneyForLottos(Money lottoPrice) {
        return lottoPrice.multiply(count());
    }

}
