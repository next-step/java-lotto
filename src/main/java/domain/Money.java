package domain;

public class Money {
    private static final int THOUSAND_UNITS = 1000;
    private int money;

    public Money(int money) {
        if (money < THOUSAND_UNITS) {
            throw new IllegalArgumentException("1000원 이상 입력하세요.");
        }
        this.money = money;
    }

    public int calcPaper() {
        return this.money / THOUSAND_UNITS;
    }

    public int calcBalance(int buyCount) {
        return (this.money - (buyCount * THOUSAND_UNITS)) / THOUSAND_UNITS;
    }

    public void checkPurchase(int lottoPaper) {
        if (this.calcPaper() < lottoPaper) {
            throw new IllegalArgumentException("돈이 부족합니다.");
        }
    }
}
