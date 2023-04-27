package lotto.domain;

public class Store {

    /**
     * 로또 발급을 담당한다.
     * - store에는 로또 리스트들이 존재한다.
     * -
     */
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
}
