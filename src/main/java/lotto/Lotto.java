package lotto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_SIZE = 6;

    private final Set<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validateInputSize(numbers);
        Set<LottoNumber> converted = toLottoNumbers(numbers);
        validateNoDuplicate(numbers, converted);
        validateSize(converted);
        this.numbers = Set.copyOf(converted);
    }

    private void validateInputSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

    private static Set<LottoNumber> toLottoNumbers(List<Integer> numbers) {
        Set<LottoNumber> result = new HashSet<>();
        for (int n : numbers) {
            result.add(LottoNumber.from(n));
        }
        return result;
    }

    private void validateNoDuplicate(List<Integer> original, Set<LottoNumber> converted) {
        if (original.size() != converted.size()) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

    private void validateSize(Set<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

    public boolean contains(LottoNumber number) {
        return numbers.contains(number);
    }

    public int matchCount(Lotto other) {
        int count = 0;
        for (LottoNumber n : numbers) {
            if (other.contains(n)) {
                count++;
            }
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
