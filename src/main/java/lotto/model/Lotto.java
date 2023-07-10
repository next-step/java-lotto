package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<LottoNumber> lottoNumbers;

    public Lotto(final List<Integer> numbers) {
        validateDuplicateLottoNumber(numbers);
        lottoNumbers = numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    private void validateDuplicateLottoNumber(List<Integer> numbers) {
        long distinctLength = numbers.stream()
                .distinct()
                .count();
        if (numbers.size() != distinctLength) throw new IllegalStateException("로또 넘버는 중복되면 안됩니다.");
    }
}
