package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottosTest {

    @DisplayName("값이 null이면 예외 throw")
    @Test
    void Lottos_null() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lottos(null);
        }).withMessageMatching("값이 null이거나 비어있습니다.");
    }

    @DisplayName("값이 비어있으면 예외 throw")
    @Test
    void Lottos_empty() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lottos(Arrays.asList());
        }).withMessageMatching("값이 null이거나 비어있습니다.");
    }

}