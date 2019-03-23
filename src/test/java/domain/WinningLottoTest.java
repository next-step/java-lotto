package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {
    @Test(expected = IllegalArgumentException.class)
    public void 당첨번호와_보너스번호가_중복되면_예외가_발생한다() {
        new WinningLotto(new Lotto(1,2,3,4,5,6), LottoNumber.getInstance(6));
    }

    @Test
    public void 로또번호를_전달하면_순위를_리턴한다() {
        WinningLotto winningLotto = new WinningLotto(
            new Lotto(1,2,3,4,5,6), LottoNumber.getInstance(7));
        Lotto lotto = new Lotto(1,2,3,4,5,7);

        assertThat(winningLotto.matchLotto(lotto)).isEqualTo(Rank.Second);
    }
}
