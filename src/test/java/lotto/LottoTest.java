package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoTest {

    @Test
    void create() {
        assertThat(new Lotto(1)).isEqualTo(new Lotto(1));
    }

}