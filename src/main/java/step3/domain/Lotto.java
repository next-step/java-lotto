package step3.domain;

import java.util.List;

public class Lotto {

    private List<LottoNumber> lotto;
    private int count;
    private boolean matchBonus;

    public Lotto(List<LottoNumber> lotto) {
        this.lotto = lotto;
    }

    public void equalCheck(LottoNumber lottoNumber, LottoNumber bonusNumber) {
        if (lotto.contains(lottoNumber)) count++;
        if (lotto.contains(bonusNumber)) setMatchBonus(true);
    }

    public List<LottoNumber> getNumbers() {
        return lotto;
    }

    public int getCount() {
        return count;
    }

    public boolean isMatchBonus() {
        return matchBonus;
    }

    public void setMatchBonus(boolean matchBonus) {
        this.matchBonus = matchBonus;
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
