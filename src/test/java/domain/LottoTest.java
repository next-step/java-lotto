package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test(expected = IllegalArgumentException.class)
    public void 번호가_6개가_아닐시_예외가_발생한다() {
        Lotto.create(1,2,3,4,5);
    }

    @Test
    public void 번호가_없으면_자동으로_생성한다() {
        Lotto lotto = Lotto.create();
        assertThat(lotto.getLottoNumbers()).hasSize(6);
    }

    @Test
    public void 로또가_해당_번호를_가지고있다() {
        Lotto lotto = Lotto.create(1,2,3,4,5,6);
        assertThat(lotto.contains(LottoNumber.of(3))).isTrue();
    }

    @Test
    public void 두개의_로또에서_같은_번호의_개수를_구할수있다() {
        Lotto lotto1 = Lotto.create(1,2,3,4,5,6);
        Lotto lotto2 = Lotto.create(4,5,6,7,8,9);

        assertThat(lotto1.matchCount(lotto2)).isEqualTo(3);
    }

    @Test
    public void 두개의_로또가_같다() {
        Lotto lotto1 = Lotto.create(1,2,3,4,5,6);
        Lotto lotto2 = Lotto.create(1,2,3,4,5,6);

        assertThat(lotto1).isEqualTo(lotto2);
    }

    @Test
    public void 두개의_로또가_다르다() {
        Lotto lotto1 = Lotto.create(1,2,3,4,5,6);
        Lotto lotto2 = Lotto.create(4,5,6,7,8,9);

        assertThat(lotto1).isNotEqualTo(lotto2);
    }
}
