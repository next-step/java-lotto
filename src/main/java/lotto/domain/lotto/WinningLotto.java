package lotto.domain.lotto;

import lotto.domain.lotto.number.LottoNumber;
import lotto.domain.lotto.number.LottoNumbers;

import java.util.Objects;

public class WinningLotto {

    private final LottoNumbers lottoNumbers;

    private WinningLotto(LottoNumbers lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validate(LottoNumbers lottoNumbers) {
        if (Objects.isNull(lottoNumbers)) {
            throw new IllegalArgumentException("로또번호들의 값은 항상 있어야합니다");
        }
    }

    public static WinningLotto of(LottoNumbers lottoNumbers) {
        return new WinningLotto(lottoNumbers);
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.getLottoNumbers().stream()
                .anyMatch(lottoNumber::equals);
    }
}
