package step2.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Lotto {
    private final LottoPrice price;
    private final LottoNumbers numbers;

    public Lotto(final Integer... numbers) {
        this(Arrays.asList(numbers));
    }

    public Lotto(final List<Integer> numbers) {
        this.numbers = new LottoNumbers(numbers);
        this.price = LottoPrice.DEFAULT;
    }

    public Lotto(final LottoPrice price, final LottoNumbers numbers) {
        this.price = price;
        this.numbers = numbers;
    }

    public long winningReward(final Lotto winningLotto) {
        return match(winningLotto).winningReward();
    }

    public long price() {
        return price.price();
    }

    public LottoMatch match(final Lotto winningLotto) {
        return numbers.match(winningLotto.numbers);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Lotto)) return false;
        final Lotto lotto = (Lotto) o;
        return Objects.equals(price, lotto.price) &&
                Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
