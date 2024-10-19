package lotto;

import lotto.domain.Winning;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WinningTest {
    @Test
    @DisplayName("매치 개수로 Winning 생성 확인")
    void fromMatchCount() {
        assertThat(Winning.fromMatchCount(0, false)).isEqualTo(Winning.NONE);
        assertThat(Winning.fromMatchCount(3, false)).isEqualTo(Winning.FIFTH);
        assertThat(Winning.fromMatchCount(4, false)).isEqualTo(Winning.FOURTH);
        assertThat(Winning.fromMatchCount(5, false)).isEqualTo(Winning.THIRD);
        assertThat(Winning.fromMatchCount(5, true)).isEqualTo(Winning.SECOND);
        assertThat(Winning.fromMatchCount(6, false)).isEqualTo(Winning.FIRST);
        assertThat(Winning.fromMatchCount(7, false)).isEqualTo(Winning.NONE);
    }
}
