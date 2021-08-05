package lottery.dto;

public class LotteryResultDto {

    private final String explanation;
    private final int cashPrize;
    private final int count;

    public LotteryResultDto(final String explanation, final int cashPrize, final int count) {
        this.explanation = explanation;
        this.cashPrize = cashPrize;
        this.count = count;
    }

    public String getExplanation() {
        return explanation;
    }

    public int getCashPrize() {
        return cashPrize;
    }

    public int getCount() {
        return count;
    }
}
