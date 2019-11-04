package step2.lotto;

import java.util.Objects;
import java.util.function.Function;

class Price {
    private final int amount;
    private final Unit unit;

    public Price(final int amount) {
        this.amount = amount;
        this.unit = Unit.WON;
    }

    Price(final int amount, final Unit unit) {
        this.amount = amount;
        this.unit = unit;
    }

    public int getPrice() {
        return unit.convert(amount);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Price)) return false;
        final Price price = (Price) o;
        return amount == price.amount &&
                unit == price.unit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, unit);
    }

    public enum Unit {
        WON(v -> v);

        Unit(final Function<Integer, Integer> converter) {
            this.converter = converter;
        }

        private final Function<Integer, Integer> converter;

        private int convert(final int amount) {
            return converter.apply(amount);
        }
    }
}
