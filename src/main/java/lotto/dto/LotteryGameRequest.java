package lotto.dto;

public class LotteryGameRequest {

    private int amountOfMoney;

    public LotteryGameRequest(int amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    public int getAmountOfMoney() {
        return amountOfMoney;
    }
}
