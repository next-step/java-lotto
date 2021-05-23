package lotto.lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto {
    private static final int MAX_COUNT = 6;
    private final Set<LottoNumber> numbers = new HashSet<>();

    public void addNumber(LottoNumber lottoNumber) {
        if (!isContain(lottoNumber)) {
            numbers.add(lottoNumber);
        }
    }

    public boolean isSelectComplete() {
        return numbers.size() >= MAX_COUNT;
    }

    public Set<LottoNumber> numbers() {
        return numbers;
    }

    private boolean isContain(LottoNumber number) {
        return numbers.stream().anyMatch(item -> item.equals(number));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }
}
