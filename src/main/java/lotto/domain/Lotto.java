package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {

    private static final int LOTTO_SIZE = 6;
    private static final String DELIMITER = ", ";

    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public Lotto(int... numbers) {
        this(Arrays.stream(numbers)
                .boxed()
                .map(LottoNumber::new)
                .collect(Collectors.toList()));
    }

    public Lotto(String numbers) {
        this(Arrays.stream(numbers.split(DELIMITER))
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toList()));
    }

    private void validate(List<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또의 숫자는 6개이어야 합니다.");
        }

        if (numbers.size() != new HashSet<>(numbers).size()) {
            throw new IllegalArgumentException("로또는 중복된 숫자를 허용하지 않습니다.");
        }
    }

    public List<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
