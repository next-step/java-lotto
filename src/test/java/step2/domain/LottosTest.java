package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottosTest {

    @DisplayName("로또 최소가격 테스트")
    @Test
    void minLottoPrice() {
        assertThatThrownBy(() -> {
            Lottos lottos = new Lottos(999, new RandomPick());
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 최소가격은 1000원 입니다");
    }
}