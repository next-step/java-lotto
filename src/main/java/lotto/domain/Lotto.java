package lotto.domain;

public class Lotto {
    private final Money money;

    public Lotto(int inputMoney) {
        this.money = new Money(inputMoney);
    }
}
