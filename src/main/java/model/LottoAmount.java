package model;

public class LottoAmount {

    private final int amount;

    public LottoAmount(int amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("로또 구매 가능한 금액은 0원 이상어야합니다.");
        }

        // 1000 단위니?
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("로또 구매를 위한 금액은 1000단위여야 합니다.");
        }
    }
}
