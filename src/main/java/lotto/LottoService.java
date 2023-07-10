package lotto;

public class LottoService {

    private final Money money;

    public LottoService(int money) {
        this.money = new Money(money);
    }
}
