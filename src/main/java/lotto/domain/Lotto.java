package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Lotto {
    private final Set<LottoNumber> lotto;
    public Lotto(Set<LottoNumber> numberSet) {
        this.lotto = validate(numberSet);
    }


    private Set<LottoNumber> validate(Set<LottoNumber> numberSet){
        if(numberSet.size() == 6){
            return numberSet;
        }
        throw new IllegalArgumentException("로또 숫자는 6자리여야 합니다");
    }

    public int matchCount(Lotto winLotto) {
        Set<LottoNumber> result = new HashSet<>(lotto);
        result.retainAll(winLotto.find());
        return result.size();

    }

    public Set<LottoNumber> find(){
        return Collections.unmodifiableSet(lotto);
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lotto.contains(lottoNumber);
    }

    public LottoRank findRank(Lotto winLotto, LottoNumber bonus) {
        if (isRank(winLotto)) {
            return LottoRank.findMatchCount(matchCount(winLotto), contains(bonus));
        }
        return LottoRank.MISS;

    }

    private boolean isRank(Lotto winLotto) {
        return matchCount(winLotto) > 2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto1 = (Lotto) o;
        return Objects.equals(lotto, lotto1.lotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto);
    }

    @Override
    public String toString() {
        return  lotto.toString();
    }
}
