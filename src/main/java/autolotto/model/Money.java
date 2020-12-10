package autolotto.model;

import autolotto.exception.NotEnoughMoneyException;

public class Money {

    private final int value;

    public Money(int value){

        if (value < 1000) {
            throw new NotEnoughMoneyException("1000원보다 작은 돈으로는 복권을 살 수 없습니다.");
        }

        this.value = value;
    }

    public int getBuyableLotto() {
        return value / 1000;
    }


}
