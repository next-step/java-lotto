package lottogame.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private static final Number price = Number.from(1_000);

    private final LottoFactory lottoFactory;

    public LottoGame(LottoFactory lottoFactory) {
        this.lottoFactory = lottoFactory;
    }

    public double calculateReturnOfRate(Lottos winnerLotto, List<Lottos> lottos) {
        Number purchaseAmount = calculatePurchaseAmount(lottos);
        Number sumOfPrize = calculateSumOfPrize(winnerLotto, lottos);
        return sumOfPrize.divide(purchaseAmount).convertValueToDouble() * 100;
    }

    public List<Rank> checkRanks(Lottos winnerLotto, List<Lottos> lottos) {
        List<Rank> ranks = new ArrayList<>();
        for (Lottos lotto : lottos) {
            ranks.add(winnerLotto.getRank(lotto));
        }
        return ranks;
    }

    public List<Lottos> createLottos(Number number) {
        return this.lottoFactory.createLottoses(number, price);
    }

    public Lottos createLotto(List<Integer> numbers) {
        return this.lottoFactory.createLotto(numbers);
    }

    private Number calculatePurchaseAmount(List<Lottos> lottos) {
        return price.multiply(Number.from(lottos.size()));
    }

    private Number calculateSumOfPrize(Lottos winnerLotto, List<Lottos> lottos) {
        Number sumOfPrize = Number.from(0);
        for (Lottos lotto : lottos) {
            sumOfPrize = sumOfPrize.add(winnerLotto.getPrize(lotto));
        }
        return sumOfPrize;
    }
}
