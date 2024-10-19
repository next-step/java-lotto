package lotto;

import lotto.domain.Winning;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WinningTest {
    @Test
    @DisplayName("매치 개수로 Winning 생성 확인")
    void fromMatchCount() {
        assertThat(Winning.fromMatchCount(0)).isEqualTo(Winning.NONE);
        assertThat(Winning.fromMatchCount(3)).isEqualTo(Winning.FIFTH);
        assertThat(Winning.fromMatchCount(4)).isEqualTo(Winning.FOURTH);
        assertThat(Winning.fromMatchCount(5)).isEqualTo(Winning.THIRD);
        assertThat(Winning.fromMatchCount(6)).isEqualTo(Winning.FIRST);
        assertThat(Winning.fromMatchCount(7)).isEqualTo(Winning.NONE);
    }
}
