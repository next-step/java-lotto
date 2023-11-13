package src.domain;

public class Money {

    private final int value;

    public Money(int value) {
        this.value = value;
    }

    public LottoV1 buyLotto() {
        int gameCount = value / LottoV1.LOTTO_PRICE;

        return LottoV1.lotto(gameCount);
    }
}
