package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WinningTypeTest {

    @Test
    void 숫자일치_3개_미만() {
        assertThat(WinningType.of(0)).isEqualTo(WinningType.NOT_WINNING);
        assertThat(WinningType.of(2)).isEqualTo(WinningType.NOT_WINNING);
    }

    @Test
    void 숫자일치_3개_이상() {
        assertThat(WinningType.of(3)).isEqualTo(WinningType.FOURTH_PLACE);
        assertThat(WinningType.of(6)).isEqualTo(WinningType.FIRST_PLACE);
    }
}
