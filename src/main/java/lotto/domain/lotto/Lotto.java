package lotto.domain.lotto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    private static final String DUPLICATE_NUMBER_MESSAGE = "중복된 번호가 있습니다";
    private static final int LOTTO_SIZE = 6;

    private Set<LottoNumber> numbers;

    public Lotto(final int ... numbers) {
        this(Arrays.stream(numbers)
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toList()));
    }

    public Lotto(final List<LottoNumber> numbers) {
        this(new HashSet<>(numbers));
    }

    public Lotto(final Set<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_MESSAGE);
        }
        this.numbers = numbers;
    }

    public static Lotto from(List<Integer> numbers) {
        return new Lotto(numbers.stream()
            .map(LottoNumber::new)
            .collect(Collectors.toList()));
    }

    public Set<LottoNumber> getNumbers() {
        return numbers;
    }
}
