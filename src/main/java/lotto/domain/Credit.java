package lotto.domain;

import calculator.PositiveNumber;

/**
 * @author han
 */
public class Credit {
    private final int price = 1_000;
    private final PositiveNumber number;

    public Credit(String input) {
        this.number = new PositiveNumber(Integer.parseInt(input) / price);
    }

    public int getNumber() {
        return number.getNumber();
    }
}
