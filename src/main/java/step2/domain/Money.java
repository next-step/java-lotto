package step2.domain;

public class Money {
    private static final int MINUMUM_MONEY = 1000;

    private int currentMoney = 0;
    private int consumptionMoney = 0;

    private Money(int money) {
        this.currentMoney = money;
    }

    public static Money of(int money) {
        if (money < MINUMUM_MONEY) {
            throw new IllegalArgumentException("로또를 하기 위해서는 최소 1000원 이상의 금액을 입력해야 합니다.");
        }

        return new Money(money);
    }

    public int getNumberOfPurchases(int goodsPrice) {
        if (currentMoney < goodsPrice) {
            throw new RuntimeException("물건의 가격이 현재 소유한 돈으로 구매가 불가능 합니다.");
        }
        int goodsCnt = currentMoney / goodsPrice;

        updatePossessionMoney(goodsPrice);

        return goodsCnt;
    }

    public double totalYield(int revenue) {
        double yield = (double)revenue / (double)consumptionMoney;
        yield = Math.round(yield * 100);
        yield = yield / 100;
        return yield;
    }

    private void updatePossessionMoney(int goodsPirce) {
        consumptionMoney = (currentMoney / goodsPirce) * goodsPirce;
        currentMoney = currentMoney - consumptionMoney;
    }
}
