package step3.domain;

import java.util.List;

public class Lotto {

    private List<LottoNumber> lotto;
    private LottoMatchStatus lottoMatchStatus;

    public Lotto(List<LottoNumber> lotto) {
        this.lotto = lotto;
        this.lottoMatchStatus = new LottoMatchStatus();
    }

    public void checkLottoMatchCount(LottoNumber lottoNumber, LottoNumber bonusNumber) {
        if (lotto.contains(lottoNumber)) lottoMatchStatus.increaseCount();
        if (lotto.contains(bonusNumber)) lottoMatchStatus.setMatchBonus(true);
    }

    public List<LottoNumber> getNumbers() {
        return lotto;
    }

    public int getCount() {
        return lottoMatchStatus.getCount();
    }

    public boolean isMatchBonus() {
        return lottoMatchStatus.isMatchBonus();
    }

    public LottoMatchStatus getLottoMatchStatus() {
        return lottoMatchStatus;
    }

    public void setLottoMatchStatus(LottoMatchStatus lottoMatchStatus) {
        this.lottoMatchStatus = lottoMatchStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lotto lotto1 = (Lotto) o;

        return lotto != null ? lotto.equals(lotto1.lotto) : lotto1.lotto == null;
    }

    @Override
    public int hashCode() {
        return lotto != null ? lotto.hashCode() : 0;
    }

    @Override
    public String toString() {
        return lotto.toString();
    }
}
