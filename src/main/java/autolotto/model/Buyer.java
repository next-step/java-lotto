package autolotto.model;

public class Buyer {
    private final Money money;
    private Lottos lottos;

    public Buyer(int money) {
        this.money = new Money(money);
    }

    public Lottos buyLottos() {
        this.lottos = new Lottos(money);
        return this.lottos;
    }

    public Lottos getLottos() {
        return lottos;
    }
}
