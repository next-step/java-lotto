package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    public void 자동추첨시_여섯개의_번호를_리턴한다() {
        Lotto lotto = new Lotto();
        assertThat(lotto.getLottoNumbers()).hasSize(6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 번호가_6개가_아닐시_예외가_발생한다() {
        new Lotto(1,2,3,4,5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 중복된_값을_가지면_예외가_발생한다() {
        new Lotto(1,2,3,3,4,5);
    }

    @Test
    public void 번호는_정렬되어_있다() {
        Lotto lotto = new Lotto(6,5,4,3,2,1);
        assertThat(lotto.getLottoNumbers()).isSorted();
    }

    @Test
    public void 로또가_해당_번호를_가지고있다() {
        Lotto lotto = new Lotto(1,2,3,4,5,6);
        assertThat(lotto.contains(LottoNumber.getInstance(3))).isTrue();
    }

    @Test
    public void 두개의_로또가_같다() {
        Lotto lotto1 = new Lotto(1,2,3,4,5,6);
        Lotto lotto2 = new Lotto(1,2,3,4,5,6);

        assertThat(lotto1.matchCount(lotto2)).isEqualTo(6);

        Lotto lotto3 = new Lotto(1,2,3,4,5,6);
        Lotto lotto4 = new Lotto(4,5,6,7,8,9);

        assertThat(lotto3.matchCount(lotto4)).isEqualTo(3);
    }
}
