package step2.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoTest {
    @Test
    void create() {
        final Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);
        assertThat(lotto).isEqualTo(new Lotto(1, 2, 3, 4, 5, 6));
    }


}