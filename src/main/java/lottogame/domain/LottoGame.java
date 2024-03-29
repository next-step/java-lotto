package lottogame.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private static final Money price = Money.from(1_000);

    public double calculateReturnOfRate(Lottos winnerLotto, List<Lottos> lottos) {
        Money purchaseAmount = calculatePurchaseAmount(lottos);
        Money sumOfPrize = calculateSumOfPrize(winnerLotto, lottos);
        Money result = sumOfPrize.divide(purchaseAmount);
        return result.formattingTwoDecimal();
    }

    public List<Rank> checkRanks(Lottos winnerLotto, List<Lottos> lottos) {
        List<Rank> ranks = new ArrayList<>();
        for (Lottos lotto : lottos) {
            ranks.add(winnerLotto.getRank(lotto));
        }
        return ranks;
    }

    public List<Lottos> createLottos(Money amount) {
        return LottoFactory.createLottoses(Number.from(amount.divide(price).convertToInt()));
    }

    public Lottos createLotto(List<Integer> numbers) {
        return LottoFactory.createLotto(numbers);
    }

    private Money calculatePurchaseAmount(List<Lottos> lottos) {
        return price.multiply(Number.from(lottos.size()));
    }

    private Money calculateSumOfPrize(Lottos winnerLotto, List<Lottos> lottos) {
        Money sumOfPrize = Money.from(0);
        for (Lottos lotto : lottos) {
            sumOfPrize = sumOfPrize.add(winnerLotto.getPrize(lotto));
        }
        return sumOfPrize;
    }
}
