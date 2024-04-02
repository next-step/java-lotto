package lottogame.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private static final Money price = Money.from(1_000);

    public Double calculateReturnOfRate(WinningLottos winnerLotto, List<Lottos> lottos) {
        Money purchaseAmount = calculatePurchaseAmount(lottos);
        Money sumOfPrize = calculateSumOfPrize(winnerLotto, lottos);
        return sumOfPrize.divide(purchaseAmount).toDouble();
    }

    public List<Rank> checkRanks(WinningLottos winnerLotto, List<Lottos> lottos) {
        List<Rank> ranks = new ArrayList<>();
        for (Lottos lotto : lottos) {
            ranks.add(winnerLotto.checkRank(lotto));
        }
        return ranks;
    }

    public List<Lottos> createLottos(Money amount) {
        return LottoFactory.createMultipleLottos(Number.from(amount.divide(price).toInt()));
    }

    public List<Lottos> createMultipleLottos(Number count) {
        return LottoFactory.createMultipleLottos(count);
    }

    public List<Lottos> createMultipleLottos(List<List<Number>> numbers) {
        return LottoFactory.createMultipleLottos(numbers);
    }

    public Number calculateCountOfLottos(Money amount) {
        return LottoFactory.calculateCountOfLottos(amount, price);
    }

    public WinningLottos createWinningLotto(List<Number> numbers, Number bonusNumber) {
        return LottoFactory.createWinningLotto(numbers, bonusNumber.intValue());
    }

    public List<Lottos> merge(List<Lottos> multipleLottos, List<Lottos> newMultipleLottos) {
        List<Lottos> merged = new ArrayList<>();
        merged.addAll(multipleLottos);
        merged.addAll(newMultipleLottos);
        return merged;
    }

    private Money calculatePurchaseAmount(List<Lottos> lottos) {
        return price.multiply(Number.from(lottos.size()));
    }

    private Money calculateSumOfPrize(WinningLottos winnerLotto, List<Lottos> lottos) {
        Money sumOfPrize = Money.from(0);
        for (Lottos lotto : lottos) {
            sumOfPrize = sumOfPrize.add(winnerLotto.calculatePrize(lotto));
        }
        return sumOfPrize;
    }
}
