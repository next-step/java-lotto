package lotto.domain;


import java.util.List;

public class LottoGame {
    public static final String PURCHASE_AMOUNT_OVER_ERORR_MESSAGE = "구입 금액을 초과하여 구매했습니다.";
    private final Lottos userManualLottos;
    private final Lottos userAutoLottos;
    private final Money amount;

    public LottoGame(int money) {
        this.userManualLottos = new Lottos();
        this.userAutoLottos = new Lottos();
        this.amount = Money.from(money);
    }

    public final int buyLotto(int count) {
        validatePurchase(count);
        return count;
    }

    private void validatePurchase(int count) {
        if (this.amount.isNotBuyingCondition(count)) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_OVER_ERORR_MESSAGE);
        }
    }

    public List<Lotto> createManualLotto(List<String> manualLottos) {
        return this.userManualLottos.createManualLotto(manualLottos);
    }

    public List<Lotto> createAutoLotto(NumberStrategy numberStrategy) {
        return this.userAutoLottos.createLottos(countOfAutoLotto(), numberStrategy);
    }

    public int countOfAutoLotto() {
        return this.amount.countOfBuyLotto(countOfManualLotto());
    }

    public int countOfManualLotto() {
        return this.userManualLottos.size();
    }

    public List<Rank> match(Lotto winningLotto, LottoNumber bonusNumber) {
        Lottos totalLotto = new Lottos();
        totalLotto.addAllLotto(this.userManualLottos);
        totalLotto.addAllLotto(this.userAutoLottos);
        return totalLotto.match(winningLotto, bonusNumber);
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
