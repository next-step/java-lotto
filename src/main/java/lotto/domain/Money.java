package lotto.domain;

public class Money {
    private final int money;

    public Money(int inputMoney) {
        validateMoney(inputMoney);
        this.money = inputMoney;
    }

    private void validateMoney(int inputMoney) {
        if (inputMoney < 0) {
            throw new IllegalArgumentException("구매 금액은 0 보다 작을 수 없습니다.");
        }
    }

    public int getAmount() {
        return money;
    }
}
