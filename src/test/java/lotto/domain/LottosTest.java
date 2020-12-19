package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    @Test
    @DisplayName("자동 번호 선택")
    void testFillAutoRemaining() {
        // given
        int size = 14;
        // when
        Lottos lottos = new Lottos(size);
        lottos.fillAutoRemaining();
        // then
        assertThat(lottos.size()).isEqualTo(size);
    }
}
