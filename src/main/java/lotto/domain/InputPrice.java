package lotto.domain;

import java.util.Objects;

import static lotto.utils.Constants.*;

public class InputPrice {
    private final int inputPrice;

    public InputPrice(Integer inputPrice) {
        validateSmallestUnit(inputPrice);
        this.inputPrice = inputPrice;
    }

    private void validateSmallestUnit(Integer inputPrice) {
        if (inputPrice < NUMBER_THOUSAND || Math.floorMod(inputPrice, NUMBER_THOUSAND) != NUMBER_ZERO) {
            throw new IllegalArgumentException(MSG_MINIMUM_PURCHASE_PRICE);
        }
    }

    public Integer divideByThousands() {
        return inputPrice / NUMBER_THOUSAND;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InputPrice that = (InputPrice) o;
        return Objects.equals(inputPrice, that.inputPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inputPrice);
    }
}
