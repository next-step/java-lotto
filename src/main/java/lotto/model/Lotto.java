package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    public static final int LOTTO_LENGTH = 6;
    private final List<LottoNumber> lottoNumbers;

    public Lotto(final List<Integer> numbers) {
        validateLotto(numbers);
        lottoNumbers = numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    private void validateLotto(final List<Integer> numbers) {
        validateLottoLength(numbers);
        validateDuplicateLottoNumber(numbers);

    }

    private void validateLottoLength(final List<Integer> numbers) {
        if (numbers.size() != LOTTO_LENGTH) throw new IllegalStateException("로또 번호는 " + LOTTO_LENGTH + "개이여야 합니다");
    }

    private void validateDuplicateLottoNumber(final List<Integer> numbers) {
        long distinctLength = numbers.stream()
                .distinct()
                .count();
        if (numbers.size() != distinctLength) throw new IllegalStateException("로또 넘버는 중복되면 안됩니다.");
    }
}
