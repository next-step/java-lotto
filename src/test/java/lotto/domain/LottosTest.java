package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {
    @Test
    @DisplayName("Lottos는 생성된 숫자만큼의 로또를 가진다")
    void size() {
        Assertions.assertThat(new Lottos(3).values()).hasSize(3);
    }
}