package lotto.domain;


import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private List<Lotto> userLottos;
    private Money amount;

    public LottoGame(int money) {
        this.userLottos = new ArrayList<>();
        this.amount = Money.from(money);
    }

    public List<Lotto> createLotto(NumberStrategy numberStrategy) {
        for (int i = 0; i < amount.countOfBuyLotto(); i++) {
            userLottos.add(Lotto.of(numberStrategy.generateNumber()));
        }
        return this.userLottos;
    }

    public List<Rank> match(String winningNumbers) {
        List<Rank> ranks = new ArrayList<>();
        Lotto winningLotto = Lotto.of(winningNumbers);
        for (Lotto lotto : this.userLottos) {
            ranks.add(Rank.from(lotto.matchCount(winningLotto)));
        }
        return ranks;
    }

    public double calculateProfit(List<Rank> lottoRanks) {
        Money totalPrize = Money.from(0);
        for (Rank rank : lottoRanks) {
            totalPrize = totalPrize.plus(rank.getPrize());
        }
        return this.amount.calculateProfitRatio(totalPrize);
    }

    public int countOfLotto() {
        return amount.countOfBuyLotto();
    }
}
