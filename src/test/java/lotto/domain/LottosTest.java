package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottosTest {

    @Test
    @DisplayName("로또를 입력받은 갯수만큼 생성한다")
    void create_lottos() {
        Lottos lottos = new Lottos(5);
        assertEquals(5, lottos.of().size());
    }
}
