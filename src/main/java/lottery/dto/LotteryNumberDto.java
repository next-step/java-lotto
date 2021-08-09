package lottery.dto;

public class LotteryNumberDto {

    private final int lotteryNumber;

    public LotteryNumberDto(final int lotteryNumber) {
        this.lotteryNumber = lotteryNumber;
    }

    public int getLotteryNumber() {
        return lotteryNumber;
    }
}
