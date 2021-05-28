package lotto;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Lotto {
    private final LottoNumber lottoNumber;

    public Lotto() {
        LottoRandomNumber lottoRandomNumber = new LottoRandomNumberUtils();
        this.lottoNumber = lottoRandomNumber.createRandomLotto();
    }

    public Lotto(LottoRandomNumber lottoRandomNumber) {
        this.lottoNumber = lottoRandomNumber.createRandomLotto();
    }

    public Lotto(List<Integer> lottoNumber) {
        Collections.sort(lottoNumber);
        this.lottoNumber = new LottoNumber(lottoNumber);
    }

    public LottoRank compareWinLottoNumber(Lotto winLottoNumber, int bonusNumber) {
        int matchCount = lottoNumber.compareWinLottoNumber(winLottoNumber);
        LottoRank lottoRank = LottoRank.searchRank(matchCount);
        if (lottoRank.isThird() || lottoRank.isSecond()) {
            System.out.println(lottoNumber.isContainNumber(bonusNumber));
            lottoRank = LottoRank.searchBonusRank(matchCount, lottoNumber.isContainNumber(bonusNumber));
        }
        return lottoRank;
    }

    public int matchNumber(Integer winNumber) {
        return lottoNumber.isContainNumber(winNumber) ? 1 : 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumber, lotto.lottoNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }

    @Override
    public String toString() {
        return lottoNumber.toString();
    }
}
