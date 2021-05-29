package lotto;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Lotto {
    private final LottoNumbers lottoNumbers;

    public Lotto() {
        LottoRandomNumber lottoRandomNumber = new LottoRandomNumberUtils();
        this.lottoNumbers = lottoRandomNumber.createRandomLotto();
    }

    public Lotto(LottoRandomNumber lottoRandomNumber) {
        this.lottoNumbers = lottoRandomNumber.createRandomLotto();
    }

    public Lotto(List<Integer> lottoNumbers) {
        Collections.sort(lottoNumbers);
        this.lottoNumbers = new LottoNumbers(lottoNumbers);
    }

    public LottoRank compareWinLotto(Lotto winLotto, LottoBonusNumber bonusNumber) {
        int matchCount = lottoNumbers.compareWinLotto(winLotto);
        LottoRank userLottoRank = LottoRank.searchRank(matchCount);
        if (userLottoRank.isThird() || userLottoRank.isSecond()) {
            userLottoRank = LottoRank.searchBonusRank(matchCount, lottoNumbers.isContainsBonusNumber(bonusNumber));
        }
        return userLottoRank;
    }

    public int matchNumber(Integer userLottoNumber) {
        return lottoNumbers.isContainWinNumber(userLottoNumber) ? 1 : 0;
    }

    public boolean isMatchNumber(Integer winNumber) {
        return lottoNumbers.isContainWinNumber(winNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
