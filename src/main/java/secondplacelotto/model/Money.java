package secondplacelotto.model;

import secondplacelotto.exception.isNotEnoughMoneyException;

public class Money {

    private int value;

    public Money(int value){

        if(value < 1000) {
            throw new isNotEnoughMoneyException("입력한 돈이 충분하지 않습니다");
        }

        this.value = value;
    }

    public int getBuybleLottoCount(){
        return this.value / 1000;
    }
}
