package lotto.domain.lotto.number;

import lotto.domain.lotto.WinningLotto;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class LottoNumbers {
    public static final int LOTTO_NUMBER_COUNT = 6;

    private final Set<LottoNumber> lottoNumbers;

    private LottoNumbers(List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> lottoNumberSet = new HashSet<>(lottoNumbers);
        validate(lottoNumberSet);
        this.lottoNumbers = lottoNumberSet;
    }

    private void validate(Set<LottoNumber> lottoNumberSet) {
        if (Objects.isNull(lottoNumberSet) || lottoNumberSet.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또번호는 총 6개여야 합니다");
        }
    }

    public static LottoNumbers of(List<LottoNumber> lottoNumbers) {
        return new LottoNumbers(lottoNumbers);
    }

    public int match(WinningLotto winningLotto) {
        return Math.toIntExact(
                lottoNumbers.stream()
                        .filter(winningLotto::contains)
                        .count());
    }

    public Set<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }
}
