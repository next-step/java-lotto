package lotto.domain;

public class Money {

    public static final long LOTTO_PRICE = 1000L;
    private final long money;

    public Money(long money) {
        validateMoney(money);
        this.money = money;
    }

    private void validateMoney(long money) {
        validateMinusMoney(money);
        validateThousandMoney(money);
    }

    private void validateMinusMoney(long money) {
        if (money < 0) {
            throw new IllegalArgumentException("돈이 음수일 수 없습니다.");
        }
    }

    private void validateThousandMoney(long money) {
        if (money % LOTTO_PRICE != 0L) {
            throw new IllegalArgumentException("천 단위의 돈을 입력해야 합니다.");
        }
    }

    public long countLotto() {
        return this.money / LOTTO_PRICE;
    }

    public double profitRate(long profit) {
        return (double) profit / (countLotto() * LOTTO_PRICE);
    }
}
