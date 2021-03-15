package lotto.dto;

import java.util.List;

public class LotteryPurchaseRequest {

    private int amountOfMoney;

    private List<LotteryNumberListDto> listOfManualLotteryNumberListDto;

    public LotteryPurchaseRequest(int amountOfMoney, List<LotteryNumberListDto> listOfManualLotteryNumberListDto) {
        this.amountOfMoney = amountOfMoney;
        this.listOfManualLotteryNumberListDto = listOfManualLotteryNumberListDto;
    }

    public int countOfPurchasableTickets(int lotteryTicketPrice) {
        return amountOfMoney / lotteryTicketPrice;
    }

    public List<LotteryNumberListDto> getListOfManualLotteryNumberList() {
        return listOfManualLotteryNumberListDto;
    }

}
