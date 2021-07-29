package lotto.domain.lotto;

import lotto.domain.lotto.number.LottoNumber;
import lotto.domain.lotto.number.LottoNumbers;
import lotto.domain.prize.LottoPrize;

import java.util.List;

public class Lotto {

    private final LottoNumbers lottoNumbers;

    private Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto of(LottoNumbers lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    public LottoPrize match(WinningLotto winningLotto) {
        return LottoPrize.of(lottoNumbers.match(winningLotto));
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers.getLottoNumbers();
    }
}
