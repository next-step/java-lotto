package lotto.domain;

import java.util.Objects;

import static lotto.utils.Constants.NUMBER_THOUSAND;
import static lotto.utils.Constants.NUMBER_ZERO;

public class InputPrice {
    private Integer inputPrice;

    public InputPrice(Integer inputPrice) {
        this.inputPrice = inputPrice;
    }

    public boolean validateSmallestUnit() {
        return inputPrice < NUMBER_THOUSAND || Math.floorDiv(inputPrice, NUMBER_THOUSAND) != NUMBER_ZERO;
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
