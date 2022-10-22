package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {

    @DisplayName("로또 생성")
    @Test
    void createTest() {
        Lottos lottos = Lottos.create(2);

        assertThat(lottos.getCount()).isEqualTo(2);
    }
}
