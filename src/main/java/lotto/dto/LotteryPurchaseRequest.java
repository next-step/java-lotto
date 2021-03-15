package lotto.dto;

import java.util.List;

public class LotteryPurchaseRequest {

    private int amountOfMoney;

    private List<ManualLotteryNumberListDto> listOfManualLotteryNumberListDto;

    public LotteryPurchaseRequest(int amountOfMoney, List<ManualLotteryNumberListDto> listOfManualLotteryNumberListDto) {
        this.amountOfMoney = amountOfMoney;
        this.listOfManualLotteryNumberListDto = listOfManualLotteryNumberListDto;
    }

    public int countOfPurchasableTickets(int lotteryTicketPrice) {
        return amountOfMoney / lotteryTicketPrice;
    }

    public List<ManualLotteryNumberListDto> getListOfManualLotteryNumberList() {
        return listOfManualLotteryNumberListDto;
    }


}
