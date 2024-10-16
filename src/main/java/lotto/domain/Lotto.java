package lotto.domain;

import java.math.BigDecimal;
import java.util.List;

public class Lotto {

    private LottoNumbers lottoNumbers;

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public LottoRankingEnum getRanking(Lotto winningLotto) {

        return LottoRankingEnum.getEnumByMatchCount(lottoNumbers.getMatchCount(winningLotto.lottoNumbers));
    }

    public LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }
}
