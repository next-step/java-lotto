package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    public void has_6_numbers() {
        Lotto lotto = new Lotto(1,2,4,4,5,6,6,7);
        assertThat(lotto.getLottoNumbers()).hasSize(6);
    }

    @Test
    public void doesnt_have_same_number() {
        Lotto lotto = new Lotto(1,2,3,4,4,5,6,6);
        assertThat(lotto.getLottoNumbers()).doesNotHaveDuplicates();
    }

    @Test
    public void check_this_lotto_number_contains() {
        Lotto lotto = new Lotto(1,2,3,4,5,6);
        assertThat(lotto.contains(LottoNumber.getInstance(3))).isTrue();
    }

    @Test
    public void both_lotto_match_count() {
        Lotto lotto1 = new Lotto(1,2,3,4,5,6);
        Lotto lotto2 = new Lotto(1,2,3,4,5,6);

        assertThat(lotto1.matchCount(lotto2)).isEqualTo(6);

        Lotto lotto3 = new Lotto(1,2,3,4,5,6);
        Lotto lotto4 = new Lotto(4,5,6,7,8,9);

        assertThat(lotto3.matchCount(lotto4)).isEqualTo(3);
    }
}
