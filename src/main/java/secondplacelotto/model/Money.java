package secondplacelotto.model;

import secondplacelotto.exception.IsNotEnoughMoneyException;

public class Money {

    private int value;

    public Money(int value){

        if(value < 1000) {
            throw new IsNotEnoughMoneyException("입력한 돈이 충분하지 않습니다");
        }

        this.value = value;
    }

    public int getBuybleLottoCount(){
        return this.value / 1000;
    }
}
