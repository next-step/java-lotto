package lottery.dto;

public class LotteryTicketResultDto {

    private static final int MINIMUM_MATCHED_NUMBERS = 3;
    final int numberOfMatchedLotteryNumbers;

    private LotteryTicketResultDto(final int numberOfMatchedLotteryNumbers) {
        this.numberOfMatchedLotteryNumbers = numberOfMatchedLotteryNumbers;
    }

    public static LotteryTicketResultDto of(final int numberOfMatchedLotteryNumbers) {
        return new LotteryTicketResultDto(numberOfMatchedLotteryNumbers);
    }

    public boolean won() {
        return numberOfMatchedLotteryNumbers >= MINIMUM_MATCHED_NUMBERS;
    }

    public int getNumberOfMatchedLotteryNumbers() {
        return numberOfMatchedLotteryNumbers;
    }
}
