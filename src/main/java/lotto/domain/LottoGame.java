package lotto.domain;


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

    public List<LottoResult> matchResult(String winningNumbers, int bonusNumber) {
        return LottoResult.matchResult(match(winningNumbers, bonusNumber));
    }

    private List<Rank> match(String winningNumbers, int bonusNumber) {
        return this.userLottos.match(winningNumbers, bonusNumber);
    }

    public double calculateProfit(String winningNumbers, int bonusNumber) {
        Money totalPrize = Money.from(0);
        for (Rank rank : match(winningNumbers, bonusNumber)) {
            totalPrize = totalPrize.plus(rank.getPrize());
        }
        return this.amount.calculateProfitRatio(totalPrize);
    }
}
