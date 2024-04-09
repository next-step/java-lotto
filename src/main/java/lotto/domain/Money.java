package lotto.domain;

public class Money {
    public static final int LOTTO_PRICE = 1000;
    public static final String BUY_LOTTO_ERORR_MESSAGE = "1000원 단위로 입력해주세요.";
    private int money;

    private Money(int money) {
        validateMoney(money);
        this.money = money;
    }

    private static void validateMoney(int money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(BUY_LOTTO_ERORR_MESSAGE);
        }
    }

    public static Money from(int money) {
        return new Money(money);
    }

    public Money plus(int otherMoney) {
        return from(this.money + otherMoney);
    }

    public double calculateProfitRatio(Money totalPrize) {
        return (double) totalPrize.money / this.money;
    }

    public boolean isNotBuyingCondition(int count) {
        return countOfBuyLotto(count) < 0;
    }

    public int countOfBuyLotto(int count) {
        return this.money / LOTTO_PRICE - count;
    }
}
