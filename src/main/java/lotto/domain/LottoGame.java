package lotto.domain;


import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private Lottos userLottos;
    private Money amount;

    public LottoGame(int money) {
        this.userLottos = new Lottos();
        this.amount = Money.from(money);
    }

    public List<Lotto> createLotto(NumberStrategy numberStrategy) {
        return this.userLottos.createLottos(countOfLotto(), numberStrategy);
    }

    public int countOfLotto() {
        return this.amount.countOfBuyLotto();
    }

    public List<Lotto> getLottos() {
        return this.userLottos.getLottos();
    }

    public List<LottoResult> matchResult(String winningNumbers) {
        return LottoResult.matchResult(match(winningNumbers));
    }

    private List<Rank> match(String winningNumbers) {
        return this.userLottos.match(winningNumbers);
    }

    public double calculateProfit(String winningNumbers) {
        Money totalPrize = Money.from(0);
        for (Rank rank : match(winningNumbers)) {
            totalPrize = totalPrize.plus(rank.getPrize());
        }
        return this.amount.calculateProfitRatio(totalPrize);
    }
}
