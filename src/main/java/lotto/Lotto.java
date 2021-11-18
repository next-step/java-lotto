package lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto {
    private static final int TOTAL_LOTTO_NUMBER_COUNT = 45;
    private static final int DEFAULT_SELECT_COUNT = 6;
    private final List<LottoNumber> numbers;

    // 자동 로또
    public Lotto() {
        this.numbers = getNumbers();
    }

    private List<LottoNumber> getNumbers() {
        final List<LottoNumber> allLottoNumbers = Stream.iterate(1, i -> i + 1)
                .limit(TOTAL_LOTTO_NUMBER_COUNT)
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        Collections.shuffle(allLottoNumbers);

        return allLottoNumbers.stream()
                .limit(DEFAULT_SELECT_COUNT)
                .sorted()
                .collect(Collectors.toList());
    }

    // 수동 로또
    public Lotto(Integer... numbers) {
        this(Arrays.asList(numbers));
    }

    public Lotto(List<Integer> numbers) {
        if (numbers.size() != DEFAULT_SELECT_COUNT) {
            throw new IllegalArgumentException("로또는 6개의 번호를 입력해야 합니다.");
        }
        this.numbers = numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public int result(Lotto target) {
        return (int) this.numbers.stream()
                .filter(target.numbers::contains)
                .count();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return numbers.containsAll(lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
