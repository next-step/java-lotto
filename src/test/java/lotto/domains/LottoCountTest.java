package lotto.domains;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoCountTest {
    @Test
    void 음수_에러_반환_테스트() {
        assertThatThrownBy(() -> new LottoCount(-1)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또갯수_반환_테스트() {
        assertThat(new LottoCount(2).count()).isEqualTo(2);
    }
}