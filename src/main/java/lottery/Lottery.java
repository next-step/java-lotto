package lottery;

public class Lottery {

    public static final int DEFAULT_LOTTERY_PRICE = 1000;

    private final LotteryNumbers lotteryNumbers;
    private final Integer price;

    public Lottery(LotteryNumbers lotteryNumbers) {
        this.lotteryNumbers = lotteryNumbers;
        this.price = DEFAULT_LOTTERY_PRICE;
    }

    public LotteryNumbers numbers() {
        return this.lotteryNumbers;
    }

    public int price() {
        return this.price;
    }
}
