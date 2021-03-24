package lottery.domain;

import static lottery.domain.LotteryTicketIssuer.LOTTERY_PRICE;

import java.util.List;
import lottery.dto.LotteryNumbersDto;
import lottery.dto.LotteryTicketOrderDto;

public class LotteryTicketOrder {

    private final int money;
    private final List<LotteryNumbersDto> lotteryNumbersDtoList;

    public LotteryTicketOrder(int money,
        List<LotteryNumbersDto> lotteryNumbersDtoList) {
        validate(money, lotteryNumbersDtoList.size());
        this.money = money;
        this.lotteryNumbersDtoList = lotteryNumbersDtoList;
    }

    public LotteryTicketOrder(LotteryTicketOrderDto dto) {
        this(dto.getMoney(), dto.getLotteryNumbersDtoList());
    }

    private void validate(int money, int amountOfManualLotteries) {
        if (money - (amountOfManualLotteries * LOTTERY_PRICE) < 0) {
            throw new ManualLotteryQuantityExceedException();
        }
    }

    public int getMoney() {
        return money;
    }

    public int getAmountOfManualLotteries() {
        return lotteryNumbersDtoList.size();
    }

    public List<LotteryNumbersDto> getLotteryNumbersDtoList() {
        return lotteryNumbersDtoList;
    }
}
