package lottery.dto;

import java.util.List;

public class LotteryTicketOrderDto {

    private final int money;
    private final List<LotteryNumbersDto> lotteryNumbersDtoList;

    public LotteryTicketOrderDto(int money,
        List<LotteryNumbersDto> lotteryNumbersDtoList) {
        this.money = money;
        this.lotteryNumbersDtoList = lotteryNumbersDtoList;
    }

    public int getMoney() {
        return money;
    }

    public List<LotteryNumbersDto> getLotteryNumbersDtoList() {
        return lotteryNumbersDtoList;
    }
}
