package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WinningTypeTest {

    @Test
    @DisplayName("매치 카운트 숫자에 따라 winningType 정해지는지 테스트")
    void findType() {
        assertThat(WinningType.findType(6)).isEqualTo(WinningType.FIRST);
        assertThat(WinningType.findType(5)).isEqualTo(WinningType.SECOND);
        assertThat(WinningType.findType(4)).isEqualTo(WinningType.THIRD);
    }
}
