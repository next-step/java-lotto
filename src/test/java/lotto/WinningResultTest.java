package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningResultTest {

    @DisplayName("WinningResult 는 당첨 번호와 로또 번호의 일치 개수에 따라 로또 개수를 기록한다")
    @Test
    void addAndCountByMatch() {
        WinningResult result = new WinningResult();

        result.add(MatchCount.of(3));
        result.add(MatchCount.of(3));
        result.add(MatchCount.of(4));

        assertThat(result.countByMatch(MatchCount.THREE)).isEqualTo(2);
        assertThat(result.countByMatch(MatchCount.FOUR)).isEqualTo(1);
        assertThat(result.countByMatch(MatchCount.FIVE)).isZero();
    }
}
