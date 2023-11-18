package step2.domain.lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber {

    private static final int LOTTO_NUMBER_COUNT = 6;

    private Set<Integer> numbers;

    public LottoNumber() {
        List<Integer> numbers = IntStream.range(1, 46).boxed().collect(Collectors.toList());
        Collections.shuffle(numbers);
        this.numbers = numbers.stream().limit(LOTTO_NUMBER_COUNT).collect(Collectors.toSet());
    }

    public LottoNumber(final Set<Integer> numbers) {
        checkValidationNumberCount(numbers.size());
        this.numbers = numbers;
    }

    public LottoNumber(final List<Integer> numbers) {
        checkValidationNumberCount(numbers.size());
        this.numbers = new HashSet<>(numbers);
    }

    private static void checkValidationNumberCount(final int lottoNumbers) {
        if (lottoNumbers != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

    public Set<Integer> getNumbers() {
        return numbers;
    }
}
