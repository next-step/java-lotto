package lotto.domain.lotto.number;

import lotto.domain.lotto.WinningLotto;

import java.util.List;
import java.util.Objects;

public class LottoNumbers {
    public static final int LOTTO_NUMBER_COUNT = 6;

    private final List<LottoNumber> lottoNumbers;

    private LottoNumbers(List<LottoNumber> lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoNumbers of(List<LottoNumber> lottoNumbers) {
        return new LottoNumbers(lottoNumbers);
    }

    private void validate(List<LottoNumber> lottoNumbers) {
        if (Objects.isNull(lottoNumbers) || lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException();
        }
    }

    public int match(WinningLotto winningLotto) {
        return Math.toIntExact(
                lottoNumbers.stream()
                        .filter(winningLotto::contains)
                        .count());
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }
}
