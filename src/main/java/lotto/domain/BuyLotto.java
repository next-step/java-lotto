package lotto.domain;

public class BuyLotto {

    private final int buyAmount;
    private final int count;
    private Lottos lottos = new Lottos();

    public BuyLotto(Money money) {
        this.buyAmount = money.getBuyAmount();
        this.count = buyLottoCount(money);
    }

    public int getbuyAmount() {
        return this.buyAmount;
    }

    public int getCount() {
        return this.count;
    }

    public int buyLottoCount(Money money) {
        return money.getBuyAmount() / money.getBuyAmoutUnit();
    }

    public void putLottos(Lotto lotto) {
        lottos.putLottos(lotto);
    }

    public Lottos getLottos() {
        return this.lottos;
    }
}
