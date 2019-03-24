package domain;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    public void 자동추첨시_여섯개의_번호를_리턴한다() {
        Lotto lotto = Lotto.auto();
        assertThat(lotto.getLottoNumbers()).hasSize(6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 번호가_6개가_아닐시_예외가_발생한다() {
        Lotto.manual(Arrays.asList(1,2,3,4,5));
    }

    @Test
    public void 로또가_해당_번호를_가지고있다() {
        Lotto lotto = Lotto.manual(Arrays.asList(1,2,3,4,5,6));
        assertThat(lotto.contains(LottoNumber.of(3))).isTrue();
    }

    @Test
    public void 두개의_로또가_같다() {
        Lotto lotto1 = Lotto.manual(Arrays.asList(1,2,3,4,5,6));
        Lotto lotto2 = Lotto.manual(Arrays.asList(1,2,3,4,5,6));

        assertThat(lotto1.matchCount(lotto2)).isEqualTo(6);

        Lotto lotto3 = Lotto.manual(Arrays.asList(1,2,3,4,5,6));
        Lotto lotto4 = Lotto.manual(Arrays.asList(4,5,6,7,8,9));

        assertThat(lotto3.matchCount(lotto4)).isEqualTo(3);
    }
}
