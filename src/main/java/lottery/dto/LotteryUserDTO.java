package lottery.dto;

import lottery.view.InputViewLotteryGame;

public class LotteryUserDTO {
    private int amountOfMoney;
    private int numberOfManual;

    public LotteryUserDTO(int amountOfMoney, int numberOfManual) {
        this.amountOfMoney = amountOfMoney;
        this.numberOfManual = numberOfManual;
    }

    public int getAmountOfMoney() {
        return amountOfMoney;
    }

    public int getNumberOfManual() {
        return numberOfManual;
    }

    public void setAmountOfMoney(int amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    public void setNumberOfManual(int numberOfManual) {
        this.numberOfManual = numberOfManual;
    }
}
