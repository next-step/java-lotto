package lotto.domain;

import java.util.Set;

public class BuyLotto {
    private final int buyAmount;
    private Count passiveCount;
    private Count autoCount;
    private final Count count;
    private Lottos lottos = new Lottos();

    public BuyLotto(Money money) {
        this.buyAmount = money.getBuyAmount();
        this.count = buyLottoCount(money);
    }

    public BuyLotto(Money money, Count passiveCount) {
        this.buyAmount = money.getBuyAmount();
        this.count = buyLottoCount(money);
        this.passiveCount = passiveCount;
        this.autoCount = getPassiveCountCalc();
    }

    private Count getPassiveCountCalc() {
        return this.count.minus(this.passiveCount);
    }

    public int getbuyAmount() {
        return this.buyAmount;
    }

    public Count buyLottoCount(Money money) {
        return new Count(money.getBuyAmount() / money.getBuyAmoutUnit());
    }

    public void putLottos(Lotto lotto) {
        lottos.putLottos(lotto);
    }

    public Lottos getLottos() {
        return this.lottos;
    }

    public Count getCount() {
        return this.count;
    }

    public Count getPassiveCount() {
        return this.passiveCount;
    }

    public Count getAutoCount() {
        return this.autoCount;
    }

    public Set<Lotto> getLottoNumbers() {
        return lottos.getLottos();
    }
}
