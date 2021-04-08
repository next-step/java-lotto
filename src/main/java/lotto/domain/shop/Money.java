package lotto.domain.shop;

public class Money {
    private long balance;

    public Money(long money) {
        if (money < 0) {
            throw new IllegalArgumentException("금액은 음수일 수 없습니다.");
        }
        this.balance = money;
    }

    public boolean withdraw(Money money) {
        if (money.balance > balance) {
            return false;
        }
        this.balance -= money.balance;
        return true;
    }

    public long getAvailableLottoCount() {
        return balance / LottoShop.LOTTO_PRICE;
    }

}
