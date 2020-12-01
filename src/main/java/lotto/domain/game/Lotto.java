package lotto.domain.game;

import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * Created By mand2 on 2020-11-18.
 * 로또 한 회차 객체
 */
public class Lotto {

    private final LottoNumberSet lottoNumberSet;

    private Lotto(LottoNumberSet lottoNumberSet) {
        this.lottoNumberSet = lottoNumberSet;
    }

    public static Lotto of(LottoNumberSet lottoNumberSet) {
        return new Lotto(lottoNumberSet);
    }

    // 로또번호 가져오기
    public Set<LottoNumber> number() {
        return this.lottoNumberSet.value();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumberSet, lotto.lottoNumberSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumberSet);
    }
}
