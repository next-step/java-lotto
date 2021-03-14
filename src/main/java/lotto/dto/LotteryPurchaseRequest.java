package lotto.dto;

import java.util.List;

public class LotteryPurchaseRequest {

    private int amountOfMoney;

    private List<List<Integer>> listOfManualLotteryNumberList;

    public LotteryPurchaseRequest(int amountOfMoney, List<List<Integer>> listOfManualLotteryNumberList) {
        this.amountOfMoney = amountOfMoney;
        this.listOfManualLotteryNumberList = listOfManualLotteryNumberList;
    }

    public List<List<Integer>> getListOfManualLotteryNumberList() {
        return listOfManualLotteryNumberList;
    }

    public int getAmountOfMoney() {
        return amountOfMoney;
    }
}
