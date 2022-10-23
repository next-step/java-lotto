package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {

    @DisplayName("로또 생성")
    @Test
    void createTest() {
        Lottos lottos = new Lottos(List.of(
            new Lotto(List.of(1, 2, 3, 4, 5, 6)),
            new Lotto(List.of(1, 2, 4, 9, 10, 40)),
            new Lotto(List.of(1, 2, 3, 12, 17, 30))
        ));

        assertThat(lottos.getCount()).isEqualTo(3);
    }
}
