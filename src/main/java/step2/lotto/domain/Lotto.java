package step2.lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    private final Set<LottoNumber> lottoNumbers;

    private static final int LOTTO_NUMBER_COUNT = 6;

    private Lotto(Set<LottoNumber> lottoNumbers) {
        validateLottoNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public Set<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableSet(lottoNumbers);
    }

    private void validateLottoNumbers(final Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 생성시 필요한 번호의 수는 6개 입니다.");
        }
    }

    public static Lotto of(final Set<Integer> inputNumbers) {
        Set<LottoNumber> lottoNumbers = inputNumbers.stream()
            .distinct()
            .map(LottoNumber::valueOf)
            .collect(Collectors.toSet());
        return new Lotto(lottoNumbers);
    }

    @Override
    public String toString() {
        return lottoNumbers.stream()
            .map(LottoNumber::getNumber)
            .sorted()
            .collect(Collectors.toList())
            .toString();
    }
}
