package lotto;

public class LottoController {
    public Money money;
    public final int numberOfLottos;

    public LottoController(int money) {
        this.money = new Money(money);
        this.numberOfLottos = this.money.price / 1000;
    }
}
