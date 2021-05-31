package lottery;

import java.util.List;

public class Lottery {

    private final LotteryNumbers lotteryNumbers;
    private final Integer price;

    public Lottery(LotteryNumbers lotteryNumbers) {
        this.lotteryNumbers = lotteryNumbers;
        this.price = 1000;
    }

    public List<Integer> numbers() {
        return List.of(1, 2, 3, 4, 5, 6);
    }

    public int price() {
        return 1000;
    }
}
