package lotto.domain;

import lotto.exception.InvalidInputException;

import java.util.Objects;

public class Exchanger {

    private static final Integer LOTTO_PRICE = 1000;
    private final Integer purchasePrice;
    private Integer amount;

    public Exchanger(String inputAmount) {
        this.purchasePrice = convertToInt(validateInput(inputAmount));
        this.amount = purchase();
    }

    public Integer purchase() {
        if (this.purchasePrice % LOTTO_PRICE != 0) {
            throw new InvalidInputException();
        }
        this.amount = this.purchasePrice / LOTTO_PRICE;
        return this.amount;
    }

    private String validateInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new InvalidInputException();
        }
        return input;
    }

    private Integer convertToInt(String purchaseAmount) {
        try {
            return Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new InvalidInputException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Exchanger)) return false;
        Exchanger exchanger = (Exchanger) o;
        return Objects.equals(purchasePrice, exchanger.purchasePrice) && Objects.equals(amount, exchanger.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(purchasePrice, amount);
    }
}
