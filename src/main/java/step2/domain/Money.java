package step2.domain;

public class Money {
    private static final int LOTTO_PRICE = 1000;

    private int currentMoney = 0;

    private Money(int money) {
        this.currentMoney = money;
    }

    public static Money of(int money) {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException("로또를 하기 위해서는 최소 1000원 이상의 금액을 입력해야 합니다.");
        }

        return new Money(money / LOTTO_PRICE * LOTTO_PRICE);
    }

    public int getNumberOfPurchases() {
        if (currentMoney < LOTTO_PRICE) {
            throw new RuntimeException("물건의 가격이 현재 소유한 돈으로 구매가 불가능 합니다.");
        }
        int goodsCnt = currentMoney / LOTTO_PRICE;

        return goodsCnt;
    }

    public double totalYield(int revenue) {
        double yield = (double)revenue / (double)currentMoney;
        yield = Math.round(yield * 100);
        yield = yield / 100;
        return yield;
    }
}
