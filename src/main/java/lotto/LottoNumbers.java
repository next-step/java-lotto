package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class LottoNumbers {
    private static final int LOTTO_SIZE = 6;

    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(final List<LottoNumber> lottoNumbers) {
        validateSize(lottoNumbers);
        validateDuplicate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validateSize(final List<LottoNumber> lottoNumbers) {
        if (Objects.isNull(lottoNumbers) || lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또는 6개만 가능합니다.");
        }
    }

    private void validateDuplicate(final List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> nonDuplicateLottoNumbers = new HashSet<>(lottoNumbers);
        if (nonDuplicateLottoNumbers.size() != lottoNumbers.size()) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }
}
