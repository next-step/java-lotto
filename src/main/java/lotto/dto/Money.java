package lotto.dto;

public class Money {

    private static final int FEE_OF_ONE_TRY = 1_000;
    private int money;

    public Money(int money) {
        this.money = money;
    }

    public int getNumOfGames(){
        return money/FEE_OF_ONE_TRY;
    }

    public int getMoney() {
        return money;
    }
}
