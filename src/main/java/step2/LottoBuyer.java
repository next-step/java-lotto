package step2;

public class LottoBuyer {
    private final Money money;
    private Lottos lottos;
    
    private LottoBuyer(final Money money) {
        this.money = money;
    }
    
    public static LottoBuyer of(final Money money) {
        return new LottoBuyer(money);
    }
    
    public void buy(final LottoStore lottoStore) {
        this.lottos = lottoStore.sell(money);
    }

    public Lottos getLottos() {
        return lottos;
    }
}
