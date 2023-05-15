package lotto.domain;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Lotto {
    private static final int SIZE = 6;

    private final Set<LottoNumber> numbers;

    public Lotto() {
        this(randomLottoNumbers());
    }

    public Lotto(Set<Integer> numbers) {
        if (isInvalidSize(numbers)) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
        this.numbers = numbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toSet());
    }

    private static TreeSet<Integer> randomLottoNumbers() {
        List<Integer> AllNumbers = LottoNumber.generateRandomLottoNumbers();
        return new TreeSet<>(AllNumbers.subList(0, SIZE));
    }

    private static boolean isInvalidSize(Set<Integer> numbers) {
        return numbers.size() != SIZE;
    }

    public Set<LottoNumber> getNumbers() {
        return numbers;
    }

    public long getMatchCount(Lotto lotto) {
        return numbers.stream()
                .filter(lotto::contains)
                .count();
    }

    public boolean contains(LottoNumber lottoNumber) {
        return numbers.stream()
                .anyMatch(number -> number.equals(lottoNumber));
    }
}
