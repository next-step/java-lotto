package lotto.domain;

import lotto.common.WinningType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class WinningTypeTest {

    @Test
    @DisplayName("winningType 테스트")
    void testWinningType() {
        assertThat(WinningType.of(6,false)).isEqualTo(WinningType.FIRST);
        assertThat(WinningType.of(5,true)).isEqualTo(WinningType.SECOND);
        assertThat(WinningType.of(5,false)).isEqualTo(WinningType.THIRD);
        assertThat(WinningType.of(4,false)).isEqualTo(WinningType.FORTH);
        assertThat(WinningType.of(3,false)).isEqualTo(WinningType.FIFTH);
        assertThat(WinningType.of(2,false)).isEqualTo(WinningType.MISS);
        assertThat(WinningType.of(1,false)).isEqualTo(WinningType.MISS);
        assertThat(WinningType.of(0,false)).isEqualTo(WinningType.MISS);
    }

    @Test
    @DisplayName("winningType exception 테스트")
    void testWinningType_shouldThrowException() {
        assertThatThrownBy(()->WinningType.of(7,false)).isInstanceOf(IllegalArgumentException.class);
    }
}
