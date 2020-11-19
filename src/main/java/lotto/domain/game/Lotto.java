package lotto.domain.game;

import lotto.domain.winning.WinningChecker;
import lotto.domain.winning.WinningNumber;
import lotto.domain.winning.WinningRank;

import java.util.List;
import java.util.Objects;

/**
 * Created By mand2 on 2020-11-18.
 * 로또 한 회차 객체
 */
public class Lotto {

    private final LottoNumber lottoNumber;
    private long result;

    private Lotto(LottoNumber lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static Lotto of(LottoNumber lottoNumber) {
        return new Lotto(lottoNumber);
    }

    public void lottoResult(WinningChecker winningChecker) {
        this.result = winningChecker.compare(this);
    }

    public WinningRank winningResult() {
        return WinningRank.getWinningRank((int) this.result);
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
