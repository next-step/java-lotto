package lottery.domain;

import lottery.dto.LotteryQuantityDto;

import java.util.Objects;
import java.util.stream.IntStream;

import static lottery.utils.NumberUtils.*;

public class LotteryQuantity {

    private final int quantity;

    public LotteryQuantity(final String number) {
        validateQuantity(number);
        this.quantity = Integer.parseInt(number);
    }

    public LotteryQuantity(final int number) {
        requirePositiveNumber(number);
        this.quantity = number;
    }

    public LotteryQuantityDto toDto() {
        return new LotteryQuantityDto(quantity);
    }

    public IntStream intStream() {
        return IntStream.range(0, quantity);
    }

    public boolean isLessThan(final LotteryQuantity lotteryQuantity) {
        return this.quantity < lotteryQuantity.quantity;
    }

    private void validateQuantity(final String number) {
        requireNonNull(number);
        requireNumber(number);
        requirePositiveNumber(Integer.parseInt(number));
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final LotteryQuantity that = (LotteryQuantity) o;
        return quantity == that.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity);
    }

    @Override
    public String toString() {
        return String.valueOf(quantity);
    }
}
