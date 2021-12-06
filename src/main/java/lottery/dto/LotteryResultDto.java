package lottery.dto;

import java.util.List;

public class LotteryResultDto {
    final int lotteryCount;
    final List<LotteryTicketResultDto> lotteryTicketResults;

    private LotteryResultDto(int lotteryCount, List<LotteryTicketResultDto> lotteryTicketResults) {
        this.lotteryCount = lotteryCount;
        this.lotteryTicketResults = lotteryTicketResults;
    }

    public static LotteryResultDto of(int size, List<LotteryTicketResultDto> lotteryTicketResults) {
        return new LotteryResultDto(size, lotteryTicketResults);
    }

    public int getLotteryCount() {
        return lotteryCount;
    }

    public List<LotteryTicketResultDto> getLotteryTicketResults() {
        return lotteryTicketResults;
    }
}
