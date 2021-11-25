package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottosTest {

    @DisplayName("원하는 개수 만큼 로또 구입")
    @Test
    void create() {
        int lottoCount = 14;
        Lottos lottos = new Lottos(lottoCount);

        assertThat(lottos.getLottos()).hasSize(lottoCount);
    }

    @DisplayName("원하는 개수 만큼 로또 구입(음수_실패)")
    @Test
    void create_fail() {
        assertThatThrownBy(() -> new Lottos(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구매 개수는 0 미만일 수 없습니다.");
    }

}
