package step2.domain;

import step2.exception.InvalidNumberInputException;

public class InputMoney {
    private static final int ZERO = 0;

    private final Integer inputMoney;

    private InputMoney(int inputMoney) {
        if (isOutOfBounds(inputMoney)) {
            throw new InvalidNumberInputException();
        }
        this.inputMoney = Integer.valueOf(inputMoney);
    }

    public static final InputMoney valueOf(int inputValue) {
        return new InputMoney(inputValue);
    }

    private final boolean isOutOfBounds(int inputMoney) {
        return inputMoney < ZERO;
    }

    public final int getInputMoney() {
        return inputMoney.intValue();
    }

}
