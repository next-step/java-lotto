package lotto.domains;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    protected static final int LOTTO_NUMBERS_SIZE = 6;

    private final List<LottoNumber> numbers;

    protected Lotto(int n1, int n2, int n3, int n4, int n5, int n6) {
        this(List.of(n1, n2, n3, n4, n5, n6));
    }

    protected Lotto(List<Integer> numbers) {
        List<LottoNumber> lottoNumbers = numbers
                .stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        validateDuplicate(lottoNumbers);

        this.numbers = lottoNumbers;
    }

    private void validateDuplicate(List<LottoNumber> numbers) {
        Set<LottoNumber> numberSet = new HashSet<>(numbers);

        if (numberSet.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("로또 숫자는 중복이 될 수 없습니다. 입력값: " + numbers);
        }
    }

    public Prize getPrize(Lotto winner) {
        long count = numbers.stream()
                .filter(num -> winner.numbers.contains(num))
                .count();

        return Prize.find(count);
    }
}
