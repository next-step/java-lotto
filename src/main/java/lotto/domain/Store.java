package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Store {

    public static final int LOTTERY_PRICE = 1000;
    private final Lotteries lotteries;

    public Store(int price) {
        int lotteryCount = calculateLotteryCount(new Price(price));
        this.lotteries = new Lotteries(lotteryCount);
    }

    private int calculateLotteryCount(Price price) {
        validateIfDivisible(price);
        return price.dividedBy(LOTTERY_PRICE);
    }

    private void validateIfDivisible(Price price) {
        if (price.isNotDivisible()) {
            throw new IllegalArgumentException("로또 가격 단위의 구입금액을 입력해 주세요");
        }
    }

    public int getLotteryCount() {
        return lotteries.size();
    }

    public Lotteries getLotteries() {
        return lotteries;
    }

    public List<Integer> getLotteryResult(List<Integer> lastWeekWinningNumbers) {
        return lotteries.calculateResult(lastWeekWinningNumbers);
    }

    public double getRateOfReturn(List<Integer> lotteryResult) {
        int totalPrice = lotteries.size() * LOTTERY_PRICE;
        int winningPrice = Collections.frequency(lotteryResult, 3) * 5_000 +
                Collections.frequency(lotteryResult, 4) * 50_000 +
                Collections.frequency(lotteryResult, 5) * 1_500_000 +
                Collections.frequency(lotteryResult, 6) * 2_000_000_000;
        return (double) winningPrice / totalPrice;
    }
}
