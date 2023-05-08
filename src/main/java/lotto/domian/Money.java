package lotto.domian;

public class Money {

    private final int money;

    public Money(int money) {
        checkUnit(money);
        this.money = money;
    }

    private void checkUnit(int money) {
        if (money % LottoCompany.PURCHASE_UNIT != 0) {
            throw new IllegalArgumentException("돈은 1000원 단위여야 합니다.");
        }
    }

    public int amount() {
        return this.money;
    }

}
