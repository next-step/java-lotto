package lotto.domain.vo;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoNumbers {
    private static final String ILLEGAL_NUMBERS_SIZE_EXCEPTION_MESSAGE = "로또 티켓 내의 로또 번호는 6개여야 합니다.";
    private static final String NOT_UNIQUE_NUMBERS_EXCEPTION_MESSAGE = "로또 숫자는 중복이 없어야 합니다.";
    private static final int VALID_LOTTO_NUMBER_COUNT = 6;

    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = lottoNumbers.stream()
            .sorted()
            .collect(Collectors.toList());
    }

    private void validate(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != VALID_LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ILLEGAL_NUMBERS_SIZE_EXCEPTION_MESSAGE);
        }

        if (getUniqueNumbers(lottoNumbers).size() != lottoNumbers.size()) {
            throw new IllegalArgumentException(NOT_UNIQUE_NUMBERS_EXCEPTION_MESSAGE);
        }
    }

    private Set<LottoNumber> getUniqueNumbers(List<LottoNumber> lottoNumbers) {
        return new HashSet<>(lottoNumbers);
    }

    public List<LottoNumber> getValue() {
        return lottoNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
