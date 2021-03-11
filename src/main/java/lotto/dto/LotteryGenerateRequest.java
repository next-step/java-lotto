package lotto.dto;

public class LotteryGenerateRequest {

    private int amountOfMoney;

    public LotteryGenerateRequest(int amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    public int getAmountOfMoney() {
        return amountOfMoney;
    }
}
