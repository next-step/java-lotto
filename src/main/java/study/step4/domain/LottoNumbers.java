package study.step4.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoNumbers {
    private static final String LOTTO_NUMBER_COUNT_ERROR = "당첨 번호는 6개 입력해주세요.";
    private static final int LOTTO_NUMBER_COUNT = 6;

    private final Set<LottoNumber> numbers;

    public LottoNumbers(Set<Integer> lottoNumbers) {
        checkLottoNumberCount(lottoNumbers);
        this.numbers = createLottoNumbers(lottoNumbers);
    }

    public LottoNumbers(int inputBonusNumber) {
        this.numbers = createBonusNumber(inputBonusNumber);
    }

    public Set<LottoNumber> readOnlyNumbers() {
        return Collections.unmodifiableSet(numbers);
    }

    private Set<LottoNumber> createLottoNumbers(Set<Integer> lottoNumbers) {
        return lottoNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
    }

    private Set<LottoNumber> createBonusNumber(int inputBonusNumber) {
        return Set.copyOf(Arrays.asList(new LottoNumber(inputBonusNumber)));
    }

    private void checkLottoNumberCount(Set<Integer> result) {
        if (result.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(LOTTO_NUMBER_COUNT_ERROR);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
