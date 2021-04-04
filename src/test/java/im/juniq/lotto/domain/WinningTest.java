package im.juniq.lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningTest {

    @Test
    @DisplayName("당첨번호와 일치되는 숫자 개수와 보너스번호 일치 여부로 등수 조회")
    void findByMatchedCount() {
        assertThat(Winning.findByMatchedCount(6, true)).isEqualTo(Winning.FIRST);
        assertThat(Winning.findByMatchedCount(6, false)).isEqualTo(Winning.FIRST);
        assertThat(Winning.findByMatchedCount(5, true)).isEqualTo(Winning.SECOND);
        assertThat(Winning.findByMatchedCount(5, false)).isEqualTo(Winning.THIRD);
        assertThat(Winning.findByMatchedCount(4, true)).isEqualTo(Winning.FOURTH);
        assertThat(Winning.findByMatchedCount(4, false)).isEqualTo(Winning.FOURTH);
        assertThat(Winning.findByMatchedCount(3, true)).isEqualTo(Winning.FIFTH);
        assertThat(Winning.findByMatchedCount(3, false)).isEqualTo(Winning.FIFTH);
        assertThat(Winning.findByMatchedCount(2, true)).isEqualTo(Winning.LOSING);
        assertThat(Winning.findByMatchedCount(2, false)).isEqualTo(Winning.LOSING);
        assertThat(Winning.findByMatchedCount(1, true)).isEqualTo(Winning.LOSING);
        assertThat(Winning.findByMatchedCount(1, false)).isEqualTo(Winning.LOSING);
        assertThat(Winning.findByMatchedCount(0, true)).isEqualTo(Winning.LOSING);
        assertThat(Winning.findByMatchedCount(0, false)).isEqualTo(Winning.LOSING);
    }
}