package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_SIZE = 6;

    private final Set<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        this(toLottoNumbers(numbers));
    }

    private Lotto(Set<LottoNumber> numbers) {
        validate(numbers);
        this.numbers = Set.copyOf(numbers);
    }

    private static Set<LottoNumber> toLottoNumbers(List<Integer> numbers) {
        Set<LottoNumber> result = new HashSet<>();
        for (int n : numbers) {
            result.add(LottoNumber.from(n));
        }
        return result;
    }

    private void validate(Set<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호는 중복 없이 " + LOTTO_SIZE + "개여야 합니다.");
        }
    }

    public boolean contains(LottoNumber number) {
        return numbers.contains(number);
    }

    public int matchCount(Lotto other) {
        int count = 0;
        for (LottoNumber n : numbers) {
            if (other.contains(n)) count++;
        }
        return count;
    }

    public List<Integer> numbers() {
        return numbers.stream()
            .map(LottoNumber::value)
            .sorted()
            .collect(Collectors.toList());
    }
}
