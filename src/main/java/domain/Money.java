package domain;

public class Money {
    private static final int THOUSAND_UNITS = 1000;
    private int money;
    private int paper;

    public Money(int money) {
        if (money < THOUSAND_UNITS) {
            throw new IllegalArgumentException("1000원 이상 입력하세요.");
        }
        this.money = money;
        this.paper = this.calcPaper();
    }

    public int calcPaper() {
        return this.money / THOUSAND_UNITS;
    }

    public void checkPurchase(int lottoPaper) {
        if (this.paper < lottoPaper) {
            throw new IllegalArgumentException("돈이 부족합니다.");
        }
    }
}
