package lotto.domain;

public class Lotto {
    private final Purchase purchase;

    public Lotto(int inputMoney) {
        purchase = new Purchase(inputMoney);
    }
}
