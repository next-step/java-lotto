package step2.domain;

public class Money {
    private static final int MINIMUM_MONEY = 1000;

    private int currentMoney = 0;

    private Money(int money) {
        this.currentMoney = money;
    }

    public static Money of(int money) {
        if (money < MINIMUM_MONEY) {
            throw new IllegalArgumentException("로또를 하기 위해서는 최소 1000원 이상의 금액을 입력해야 합니다.");
        }

        return new Money(money / MINIMUM_MONEY * MINIMUM_MONEY);
    }

    public int getNumberOfPurchases(int goodsPrice) {
        if (currentMoney < goodsPrice) {
            throw new RuntimeException("물건의 가격이 현재 소유한 돈으로 구매가 불가능 합니다.");
        }
        int goodsCnt = currentMoney / goodsPrice;

        return goodsCnt;
    }

    public double totalYield(int revenue) {
        double yield = (double)revenue / (double)currentMoney;
        yield = Math.round(yield * 100);
        yield = yield / 100;
        return yield;
    }
}
