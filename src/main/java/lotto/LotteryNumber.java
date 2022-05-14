package lotto;

public class LotteryNumber {
    private final int value;

    public LotteryNumber(int value) {
        if (value < 1 || value > 45) {
            throw new IllegalArgumentException("Lottery Number should be 1 ~ 45");
        }
        this.value = value;
    }
}
