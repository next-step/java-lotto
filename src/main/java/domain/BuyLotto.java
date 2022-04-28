package domain;

public class BuyLotto {
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private final int money;
    private static final int LOTTO_PRICE = 1000;
    private final Lottos lottos;

    public BuyLotto(int money) {
        this.money = money;
        this.lottos = new Lottos(new LottoGenerator(START_NUMBER, END_NUMBER), buyLottoCount());
    }

    public int buyLottoCount() {
        return this.money / LOTTO_PRICE;
    }

    public String buyLottoList() {
        return lottos.toString();
    }
}
