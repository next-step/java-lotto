package domain;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class LottoNumbers {
    private static int LOTTO_NUMBER_COUNT = 6;
    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        validateNumberCount(lottoNumbers);
        validateDuplicate(lottoNumbers);

        this.lottoNumbers = lottoNumbers;
    }

    private void validateDuplicate(List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> noDuplicateLottoNumbers = new HashSet<>(lottoNumbers);
        if (noDuplicateLottoNumbers.size() != lottoNumbers.size()) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

    private void validateNumberCount(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(String.format("로또 번호는 %d개여야 합니다.", LOTTO_NUMBER_COUNT));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return lottoNumbers.equals(that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
