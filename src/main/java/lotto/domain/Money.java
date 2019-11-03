package lotto.domain;

import java.util.Map;

public class Money {

    public static final String MONEY_RANGE_ERROR = "구매 금액은 음수가 될 수 없습니다.";
    public static final String MONEY_UNIT_ERROR = "로또는 1,000 원 단위로 구매할 수 있습니다.";
    private static int LOTTO_PRICE = 1000;
    
    private final int money;

    public Money(int money) {
        assertMoney(money);
        this.money = money;
    }

    public double getProfitRate(Map<LottoRank, Long> rankGroup) {
        long totalProfit = rankGroup
                .entrySet()
                .stream()
                .map(e -> e.getKey().getWinning() * e.getValue())
                .reduce(0L, Long::sum);

        return totalProfit / money;
    }

    public int getLottoCount() {
        return money / LOTTO_PRICE;
    }
    
    private void assertMoney(int money) {
        assertMoneyRange(money);
        assertMoneyUnit(money);
    }

    private void assertMoneyRange(int money) {
        if (money < 0) {
            throw new IllegalArgumentException(MONEY_RANGE_ERROR);
        }
    }
    
    private void assertMoneyUnit(int money) {
        if (money == 0 || money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(MONEY_UNIT_ERROR);
        }
    }
}
