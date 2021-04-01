package step2;

import org.junit.jupiter.api.Test;
import step2.domain.Lotto;
import step2.domain.User;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    void 로또_3개_일치() {
        Lotto winninglotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        Lotto lotto = new Lotto(Arrays.asList(33,44,45,4,5,6));
        assertThat(new User().winningConfirm(winninglotto, lotto)).isEqualTo(3);
    }
    @Test
    void 로또_6개_일치() {
        Lotto winninglotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        Lotto lotto = new Lotto(Arrays.asList(4,3,5,2,6,1));
        assertThat(new User().winningConfirm(winninglotto, lotto)).isEqualTo(6);
    }
}
