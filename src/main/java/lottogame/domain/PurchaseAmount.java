package lottogame.domain;

import lottogame.validator.PurchaseAmountValidator;
import lottogame.validator.Validatable;

public class PurchaseAmount {

    public static final long LOTTO_PRICE = 1_000;

    private final long value;

    private final Validatable<Long> validator = new PurchaseAmountValidator();

    public PurchaseAmount(InputLine inputLine) {
        this(Long.parseLong(inputLine.getLine()));
    }

    public PurchaseAmount(long value) {
        validator.validate(value);
        this.value = value;
    }

    public long getValue() {
        return value;
    }

    public long getLottoCount() {
        return value / LOTTO_PRICE;
    }
}