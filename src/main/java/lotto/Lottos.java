package lotto;

import java.math.BigDecimal;
import java.util.*;

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

    public Map<Rank, Integer> calculateMatchCount(WinnerLotto winLotto) {
        Map<Rank, Integer> matchCounts = new HashMap<>();
        int increment = 1;

        for(Lotto lotto : lottos) {
            Rank rank = winLotto.calculateRank(lotto);
            matchCounts.merge(rank, increment, Integer::sum);
        }

        return matchCounts;
    }

    public BigDecimal calculateProfit(WinnerLotto winnerLotto, Money lottoPrice) {
        Money totalWinPrice = new Money();

        for (Lotto lotto : lottos) {
            Rank rank = winnerLotto.calculateRank(lotto);
            Money winPrice = rank.winPrice();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lottos other = (Lottos) o;
        return Objects.equals(lottos, other.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos);
    }
    
}
