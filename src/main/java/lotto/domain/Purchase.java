package lotto.domain;

public class Purchase {
    private final int PRICE = 1000;
    private final int money;
    private final int count;

    public Purchase(int inputMoney) {
        validateMoney(inputMoney);
        this.money = inputMoney;
        this.count = inputMoney / PRICE;
    }

    private void validateMoney(int inputMoney) {
        if (inputMoney < 0) {
            throw new IllegalArgumentException("구매 금액은 0 보다 작을 수 없습니다.");
        }
    }

    public int money() {
        return money;
    }

    public int count() {
        return count;
    }
}
