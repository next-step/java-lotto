package step2.domain;

import step2.exception.InvalidNumberInputException;

import java.util.Objects;

public final class InputMoney {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InputMoney that = (InputMoney) o;
        return Objects.equals(inputMoney, that.inputMoney);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inputMoney);
    }

}
