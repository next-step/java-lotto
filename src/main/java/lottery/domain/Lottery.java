package lottery.domain;

public class Lottery {

    public static final int DEFAULT_LOTTERY_PRICE = 1000;

    private final LotteryNumbers lotteryNumbers;
    private final Price price;

    public Lottery(LotteryNumbers lotteryNumbers) {
        this.lotteryNumbers = lotteryNumbers;
        this.price = new Price(DEFAULT_LOTTERY_PRICE);
    }

    public LotteryNumbers numbers() {
        return this.lotteryNumbers;
    }

    public Price price() {
        return this.price;
    }
}
