package step2.lotto.domain;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    private final Set<Integer> lottoNumbers;

    private static final int LOTTO_MINIMUM_BOUND = 1;
    private static final int LOTTO_MAXIMUM_BOUND = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    public Lotto(Set<Integer> lottoNumbers) {
        validateLottoNumbers(lottoNumbers);
        validateNumberBound(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public Set<Integer> getLottoNumbers() {
        return Collections.unmodifiableSet(lottoNumbers);
    }

    private void validateLottoNumbers(final Set<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 생성시 필요한 번호의 수는 6개 입니다.");
        }
    }

    private void validateNumberBound(final Set<Integer> lottoNumbers) {
        lottoNumbers.stream().forEach(number -> {
            if(number > LOTTO_MAXIMUM_BOUND || number < LOTTO_MINIMUM_BOUND) {
                throw new IllegalArgumentException("로또 번호는 1이상 45이하의 숫자들로만 이루어져야 합니다.");
            }
        });
    }

    @Override
    public String toString() {
        return lottoNumbers.stream()
            .sorted()
            .collect(Collectors.toList())
            .toString();
    }
}
