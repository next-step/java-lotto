package domain;

public class BuyLotto {
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int LOTTO_PRICE = 1000;
    private final int money;
    private final Lottos lottos;

    public BuyLotto(int money) {
        validate(money);
        this.money = money;
        this.lottos = new Lottos(new LottoGenerator(START_NUMBER, END_NUMBER), buyLottoCount());
    }

    private void validate(int money) {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException("로또는 1게임 당 1,000원 입니다.");
        }
    }

    public int buyLottoCount() {
        return this.money / LOTTO_PRICE;
    }

    public String buyLottoList() {
        return lottos.toString();
    }

}
