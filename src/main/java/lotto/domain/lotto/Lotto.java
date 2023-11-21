package lotto.domain.lotto;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    public static final int NUMBER_COUNT = 6;

    private static final String NUMBER_COUNT_ERROR_MESSAGE = String.format("로또 번호는 총 %s자리 입니다", NUMBER_COUNT);

    private final Set<LottoNumber> lottoNumbers;

    private Lotto(Collection<Integer> lottoNumbers) {
        this.lottoNumbers = new HashSet<>(validate(lottoNumbers));
    }

    public static Lotto of(Integer... lottoNumbers) {
        return of(List.of(lottoNumbers));
    }

    public static Lotto of(Collection<Integer> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    private Collection<LottoNumber> validate(Collection<Integer> lottoNumbers) {
        validateCount(lottoNumbers);
        return lottoNumbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toSet());
    }

    private void validateCount(Collection<Integer> lottoNumbers) {
        if (lottoNumbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException(NUMBER_COUNT_ERROR_MESSAGE);
        }
    }

    public long matchCount(Lotto lotto) {
        return lottoNumbers.stream()
                .filter(lotto.lottoNumbers::contains)
                .count();
    }

    public boolean contains(LottoNumber number) {
        return lottoNumbers.contains(number);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
