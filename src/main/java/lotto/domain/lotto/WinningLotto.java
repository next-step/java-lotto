package lotto.domain.lotto;

import lotto.domain.lotto.number.LottoNumber;
import lotto.domain.lotto.number.LottoNumbers;

import java.util.List;

public class WinningLotto {

    private final LottoNumbers lottoNumbers;

    private WinningLotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static WinningLotto of(LottoNumbers lottoNumbers) {
        return new WinningLotto(lottoNumbers);
    }

    public LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.getLottoNumbers().stream()
                .anyMatch(lottoNumber::equals);
    }
}
