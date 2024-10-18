package lotto.domain;

import java.math.BigDecimal;
import java.util.Arrays;

public class Lotto {

    private LottoNumbers lottoNumbers;

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public int getMatchCount(Lotto lotto) {
        return lottoNumbers.getMatchCount(lotto);
    }

    public boolean equals(Lotto lotto) {
        return lottoNumbers.equals(lotto.getLottoNumbers());
    }

    public BigDecimal getWinningAmount(WinningLotto winningLotto) {
        LottoRankEnum rank = Arrays.stream(LottoRankEnum.values()).filter(x -> x.isMatch(winningLotto, this)).findFirst().orElseThrow();
        return rank.getWinningAmount();
    }



    public LottoRankEnum getRank(WinningLotto winningLotto) {
        return  Arrays.stream(LottoRankEnum.values()).filter(x -> x.isMatch(winningLotto, this)).findFirst().orElseThrow();


    }

    public LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }
}
