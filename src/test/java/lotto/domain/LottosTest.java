package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {

    @DisplayName("로또 개수")
    @Test
    void countTest() {
        Lottos lottos = new Lottos(List.of(new Lotto(), new Lotto()));

        assertThat(lottos.getCount()).isEqualTo(2);
    }
}
