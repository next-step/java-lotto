public class LottoMoney {
    public static final int LOTTO_PRICE = 1000;
    private final int money;

    public LottoMoney(int inputMoney) {
        if (inputMoney < LOTTO_PRICE) {
            throw new IllegalArgumentException();
        }
        this.money = inputMoney;
    }

    public int count() {
        return money / LOTTO_PRICE;
    }
}
