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
}
