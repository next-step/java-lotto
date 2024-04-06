package lotto.domain;


import java.util.List;
import java.util.stream.Collectors;

public class LottoGame {
    private final Lottos userManualLottos;
    private final Lottos userAutoLottos;
    private final Money amount;

    public LottoGame(int money) {
        this.userManualLottos = new Lottos();
        this.userAutoLottos = new Lottos();
        this.amount = Money.from(money);
    }

    public List<Lotto> createAutoLotto(NumberStrategy numberStrategy) {
        return this.userAutoLottos.createLottos(countOfAutoLotto(), numberStrategy);
    }

    public int countOfAutoLotto() {
        return this.amount.countOfBuyLotto() - countOfManualLotto();
    }

    public int countOfManualLotto() {
        return this.userManualLottos.lottoSize();
    }

    public List<Lotto> createManualLotto(List<String> manualLottos) {
        return this.userManualLottos.createManualLotto(manualLottos);
    }

    public List<Rank> match(Lotto winningLotto, LottoNumber bonusNumber) {
        return this.getAllLotto().stream()
                .map(lotto -> Rank.of(lotto.matchCount(winningLotto), lotto.isContains(bonusNumber)))
                .collect(Collectors.toList());
    }

    public List<Lotto> getAllLotto() {
        return this.userManualLottos.addAllLotto(this.userAutoLottos);
    }

    public double calculateProfit(List<Rank> ranks) {
        Money totalPrize = Money.from(0);
        for (Rank rank : ranks) {
            totalPrize = totalPrize.plus(rank.getPrize());
        }
        return this.amount.calculateProfitRatio(totalPrize);
    }
}
