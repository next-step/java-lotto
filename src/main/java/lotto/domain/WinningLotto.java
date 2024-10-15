package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class WinningLotto {

    private static final String DELIMITER = ", ";

    private final Lotto lotto;

    public WinningLotto(Lotto lotto) {
        this.lotto = lotto;
    }

    public WinningLotto(int... numbers) {
        this(new Lotto(numbers));
    }

    public WinningLotto(List<Integer> numbers) {
        this(new Lotto(numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList())));
    }

    public WinningLotto(String numbers) {
        this(Arrays.stream(numbers.split(DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
    }

    public int match(Lotto userLotto) {
        return userLotto.getLottoNumbers()
                .stream()
                .filter(lotto.getLottoNumbers()::contains)
                .mapToInt(n -> 1)
                .sum();
    }

    public int match(int... numbers) {
        return Arrays.stream(numbers)
                .filter(value -> lotto.getLottoNumbers().contains(new LottoNumber(value)))
                .map(value -> 1)
                .sum();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningLotto that = (WinningLotto) o;
        return Objects.equals(lotto, that.lotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto);
    }
}
