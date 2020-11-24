package lotto.domain.game;

import java.util.List;
import java.util.Objects;

/**
 * Created By mand2 on 2020-11-18.
 * 로또 한 회차 객체
 */
public class Lotto {

    private final LottoNumber lottoNumber;

    private Lotto(LottoNumber lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static Lotto of(LottoNumber lottoNumber) {
        return new Lotto(lottoNumber);
    }

    // 로또번호 가져오기
    public List<Integer> number() {
        return this.lottoNumber.value();
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
}
