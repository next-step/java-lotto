package lotto;

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

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public LottoRank compareWinLotto(Lotto winLotto, LottoNumber bonusNumber) {
        int matchCount = lottoNumbers.countMatchWinLottoNumber(winLotto);
        LottoRank userLottoRank = LottoRank.searchRank(matchCount);
        if (userLottoRank.isThird() || userLottoRank.isSecond()) {
            userLottoRank = LottoRank.searchBonusRank(matchCount, lottoNumbers.isContainsNumber(bonusNumber));
        }
        return userLottoRank;
    }

    public boolean isContainsNumber(LottoNumber bonusNumber) {
        return lottoNumbers.isContainsNumber(bonusNumber);
    }

    public int matchNumber(LottoNumber userLottoNumber) {
        return lottoNumbers.isContainsNumber(userLottoNumber) ? 1 : 0;
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
