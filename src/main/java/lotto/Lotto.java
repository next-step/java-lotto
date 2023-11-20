package lotto;

import java.util.*;

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
}
