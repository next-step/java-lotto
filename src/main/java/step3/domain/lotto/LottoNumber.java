package step3.domain.lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber {

    private static final int LOTTO_NUMBER_COUNT = 6;

    private static final List<Integer> NUMBER_LIST = IntStream.range(1, 46).boxed().collect(Collectors.toList());

    private final Set<Integer> numbers;

    public LottoNumber() {
        Collections.shuffle(NUMBER_LIST);
        this.numbers = NUMBER_LIST.stream().limit(LOTTO_NUMBER_COUNT).collect(Collectors.toSet());
    }

    public LottoNumber(final Set<Integer> numbers) {
        checkValidationNumberCount(numbers.size());
        this.numbers = numbers;
    }

    public LottoNumber(final List<Integer> numbers) {
        this(new HashSet<>(numbers));
    }

    private static void checkValidationNumberCount(final int count) {
        if (count != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

    public Set<Integer> getNumbers() {
        return numbers;
    }

    public boolean hasBonusNumber(final int bonusNumber) {
        return this.numbers.contains(bonusNumber);
    }

    public boolean hasNumber(final int number) {
        return this.numbers.contains(number);
    }
}
