package lottery.dto;

import java.util.List;

public class LotteryTicketOrderDto {

    private final int money;
    private final List<LotteryNumbersDto> rawManualLotteries;

    public LotteryTicketOrderDto(int money, List<LotteryNumbersDto> rawManualLotteries) {
        this.money = money;
        this.rawManualLotteries = rawManualLotteries;
    }

    public int getMoney() {
        return money;
    }

    public List<LotteryNumbersDto> getmanualLotteryNumbers() {
        return rawManualLotteries;
    }
}
