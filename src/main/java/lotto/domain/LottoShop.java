package lotto.domain;

public class LottoShop {

    public static final int LOTTO_PRICE = 1000;

    private final Cashier cashier = new Cashier();

    public Lottos buyLottos(int money) { //LottoShop의 책임이 너무 없나? 하는 생각. Cashier의 일을 LottoShop으로 다시 가져와야하는지 고민.
        return cashier.pay(money);
    }

}
