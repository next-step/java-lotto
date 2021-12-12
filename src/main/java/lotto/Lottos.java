package lotto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private static final Money LOTTO_PRICE = new Money(1000);

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int count() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return new ArrayList<>(lottos);
    }

    public int calculateMatchCount(Lotto winnerLotto, int expectedMatchCount) {
        return (int) lottos.stream()
                .map(lotto -> lotto.countMatch(winnerLotto))
                .filter(matchCount -> matchCount == expectedMatchCount)
                .count()
                ;
    }

    public BigDecimal calculateProfit(Lotto winnerLotto) {
        Money totalWinPrice = new Money();

        for(Lotto lotto : lottos) {
            int matchCount = lotto.countMatch(winnerLotto);
            Money winPrice = LottoWin.winPriceOf(matchCount);
            totalWinPrice = totalWinPrice.add(winPrice);
        }

        return totalWinPrice.calculateProfit(moneyForLottos());
    }

    private Money moneyForLottos() {
        return LOTTO_PRICE.multiply(count());
    }

}
