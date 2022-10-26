package domain;

import exception.NotValidInputException;

public class Money {

    private int purchasedMoney;

    public Money(int purchasedMoney) {
        inputValidation(purchasedMoney);
        this.purchasedMoney = purchasedMoney;
    }

    public static Money from(int purchasedMoney) {

        return new Money(purchasedMoney);
    }

    private void inputValidation(int input) {
        if (input <= 0) {
            throw new NotValidInputException("양의 숫자만 입력하세요");
        }
    }

    public int getMoney() {
        return purchasedMoney;
    }

}
