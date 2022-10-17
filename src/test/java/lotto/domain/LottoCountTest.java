package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoCountTest {

    @Test
    void create() {
        LottoCount actual = new LottoCount(1);

        assertThat(actual).isEqualTo(new LottoCount(1));
    }
}
