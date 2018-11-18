package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test(expected = IllegalArgumentException.class)
    public void 로또_번호_갯수오류() throws Exception {
        Lotto lotto = Lotto.manual("1, 2, 3, 4, 5");
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또_번호_갯수초과() throws Exception {
        Lotto lotto = Lotto.manual("1, 2, 3, 4, 5, 6, 7");
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또_번호가_1보다_작을때_오류() throws Exception {
        Lotto lotto = Lotto.manual("0, 2, 3, 4, 5, 6");
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또_번호가_45보다_클때_오류() throws Exception {
        Lotto lotto = Lotto.manual("1, 2, 3, 100, 5, 6");
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또번호_중복체크() {
        Lotto lotto = Lotto.manual("1, 2, 3, 3, 5, 6");
    }

    @Test
    public void 로또_2등당첨_확인() {
        Lotto lotto = Lotto.manual("1, 2, 3, 4, 5, 6");
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,8", 6);
        Rank rank = winningLotto.getRank(lotto);
        assertThat(rank).isEqualTo(Rank.SECOND);
    }
}
