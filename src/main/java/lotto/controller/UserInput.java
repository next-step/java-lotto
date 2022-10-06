package lotto.controller;

import calculator.domain.Operator;

public class UserInput {

    private final int inputPrice;

    public UserInput(int inputPrice) {
        this.inputPrice = inputPrice;
    }

    public int getInputPrice() {
        return inputPrice;
    }
}
