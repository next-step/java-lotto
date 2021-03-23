package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottosTest {

    @Test
    @DisplayName("구입한 로또 개수만큼 객체생성")
    void of() {
        Lottos lottos = Lottos.of(5);
        assertThat(lottos.getLottos().size()).isEqualTo(5);
    }
}
