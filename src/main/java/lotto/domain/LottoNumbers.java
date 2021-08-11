package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoNumbers {
    public static final int LOTTO_NUMBERS_SIZE = 6;

    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(final List<LottoNumber> lottoNumbers) {
        validateSize(lottoNumbers);
        validateDuplicate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validateSize(final List<LottoNumber> lottoNumbers) {
        if (Objects.isNull(lottoNumbers) || lottoNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("로또는 6개만 가능합니다.");
        }
    }

    private void validateDuplicate(final List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> nonDuplicateLottoNumbers = new HashSet<>(lottoNumbers);
        if (nonDuplicateLottoNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

    public LottoStatus check(final LottoNumbers winningNumbers) {
        int hitCount = 0;
        for (LottoNumber lottoNumber : lottoNumbers) {
            hitCount += checkWinning(winningNumbers.lottoNumbers, lottoNumber);
        }
        return LottoStatus.find(hitCount);
    }

    private int checkWinning(final List<LottoNumber> winningNumbers, final LottoNumber lottoNumber) {
        if (winningNumbers.contains(lottoNumber)) {
            return 1;
        }
        return 0;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumbers.stream()
                .map(LottoNumber::getLottoNumber)
                .collect(Collectors.toList()));
    }
}
