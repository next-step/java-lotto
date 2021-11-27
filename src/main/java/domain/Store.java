package domain;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Store {
    private static final String PRICE_NULL_ERROR_MESSAGE = "error : 로또 금액은 Null 값을 입력할수 없습니다.";
    private static final String PRICE_MIN_ERROR_MESSAGE = "error : 로또 최소가격은 1000원 입니다.";
    private static final String LOTTERY_MANUAL_COUNT_ERROR_MESSAGE = "error : 구매 개수보다 수동 개수가 많습니다.";
    private static final int LOTTERY_PRICE_MIN = 1000;

    private final int lotteryCount;
    private final int manualCount;

    public Store(int price) {
        this(price, 0);
    }

    public Store(int price, int manualCount) {
        checkPriceNull(price);
        validPriceMin(price);
        this.lotteryCount = buyLotteryTicket(price);
        this.manualCount = validManualCount(manualCount);
    }

    private void checkPriceNull(int price) {
        if (Objects.isNull(price)) {
            throw new IllegalArgumentException(PRICE_NULL_ERROR_MESSAGE);
        }
    }

    private void validPriceMin(int price) {
        if (price < LOTTERY_PRICE_MIN) {
            throw new IllegalArgumentException(PRICE_MIN_ERROR_MESSAGE);
        }
    }

    public LotteryTickets createLotteryNumber(List<Set<Integer>> manualNumber) {
        return new LotteryTickets(lotteryCount, manualNumber);
    }

    private int buyLotteryTicket(int price) {
        return discard(price) / LOTTERY_PRICE_MIN;
    }

    public int discard(int price) {
        return Math.round(calculate(price)) * LOTTERY_PRICE_MIN;
    }

    private int calculate(int price) {
        return price / LOTTERY_PRICE_MIN;
    }

    private int validManualCount(int manualCount) {
        int number = lotteryCount - manualCount;
        if (number < 0){
            throw new IllegalArgumentException(LOTTERY_MANUAL_COUNT_ERROR_MESSAGE);
        }
        return manualCount;
    }

    public int lotteryCount() {
        return lotteryCount;
    }

    public int lotteryManualCount() {
        return manualCount;
    }

    public int lotteryAutomaticCount() {
        return lotteryCount - manualCount;
    }

}
