package step2;

public class InputView {
    private static final int LOTTO_PRICE = 1000;

    public int getLottoCnt(int amount) {
        amountValidate(amount);
        return amount / LOTTO_PRICE;
    }

    public void amountValidate(int amount) {
        if (amount % LOTTO_PRICE > 0) {
            throw new IllegalArgumentException("금액은 천원 단위로 입력해주세요");
        }
    }
}
