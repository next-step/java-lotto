package domain;

import java.util.List;

public class Lotto {
    private LottoNumbers lotto;

    public Lotto(LottoNumbers lottoNumber) {
        this.lotto = lottoNumber;
    }

    public boolean isContains(LottoNo winningNumber) {
        return lotto.isContains(winningNumber);
    }

    public int matchCount(List<LottoNo> lottoNumbers) {
        int matchCount = 0;
        for (LottoNo lottoNumber : lottoNumbers) {
            if (this.isContains(lottoNumber)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    @Override
    public String toString() {
        return lotto.toString();
    }
}
