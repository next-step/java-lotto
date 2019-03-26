package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test(expected = IllegalArgumentException.class)
    public void 번호가_6개가_아닐시_예외가_발생한다() {
        Lotto.create(NumberSet.fill(1,2,3,4,5));
    }

    @Test
    public void 번호가_없으면_자동으로_생성한다() {
        Lotto lotto = Lotto.create(NumberSet.empty());
        assertThat(lotto.getLottoNumbers()).hasSize(6);
    }

    @Test
    public void 로또가_해당_번호를_가지고있다() {
        Lotto lotto = Lotto.create(NumberSet.fill(1,2,3,4,5,6));
        assertThat(lotto.contains(LottoNumber.of(3))).isTrue();
    }

    @Test
    public void 두개의_로또가_같다() {
        Lotto lotto1 = Lotto.create(NumberSet.fill(1,2,3,4,5,6));
        Lotto lotto2 = Lotto.create(NumberSet.fill(1,2,3,4,5,6));

        assertThat(lotto1.matchCount(lotto2)).isEqualTo(6);

        Lotto lotto3 = Lotto.create(NumberSet.fill(1,2,3,4,5,6));
        Lotto lotto4 = Lotto.create(NumberSet.fill(4,5,6,7,8,9));

        assertThat(lotto3.matchCount(lotto4)).isEqualTo(3);
    }
}
