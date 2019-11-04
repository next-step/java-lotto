package step2.lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static step2.lotto.LottoConstant.DEFAULT_LOTTO_PRICE;
import static step2.lotto.LottoConstant.LOTTO_NUMBER_LENGTH;

public class Lotto {
    private final List<Integer> numbers;
    private final Price price;

    public Lotto(final Integer... numbers) {
        this(Arrays.asList(numbers), new Price(DEFAULT_LOTTO_PRICE));
    }

    public Lotto(final List<Integer> numbers) {
        this(numbers, new Price(DEFAULT_LOTTO_PRICE));
    }

    public Lotto(final List<Integer> numbers, final Price price) {
        if (numbers.size() != LOTTO_NUMBER_LENGTH) {
            throw new IllegalArgumentException(String.format("lotto numbers size should be %s", LOTTO_NUMBER_LENGTH));
        }
        this.numbers = numbers;
        this.price = price;
    }

    public int getPrice() {
        return price.getPrice();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Lotto)) return false;
        final Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers) &&
                Objects.equals(price, lotto.price);
    }

    public boolean equalsIgnoreNumberOrder(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Lotto)) return false;
        final Lotto lotto = (Lotto) o;
        return numbers.containsAll(lotto.numbers) &&
                Objects.equals(price, lotto.price);
    }

    public boolean matchesAll(final List<Integer> targets) {
        return numbers.containsAll(targets);
    }

    public boolean matches(final List<Integer> targets, final int boundInclusive) {
        return boundInclusive == numbers.stream()
                                        .filter(targets::contains)
                                        .count();
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers, price);
    }

    @Override
    public String toString() {
        return numbers.stream()
                      .map(Object::toString)
                      .collect(Collectors.joining(", ", "[", "]"));
    }
}
