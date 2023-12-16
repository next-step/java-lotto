package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class MatchResultTest {

    @Test
    @DisplayName("수익률 계산 : 수익률 = (당첨금액*개수)의 합 / 구입금액")
    void 수익률_계산() {
        MatchResult matchResult = new MatchResult(Map.of(
                Rank.FIRST, 0,
                Rank.SECOND, 0,
                Rank.THIRD, 0,
                Rank.FOURTH, 0,
                Rank.FIFTH, 1,
                Rank.MISS, 0
        ));

        assertThat(matchResult.calculateReturnRate(14000)).isEqualTo(0.35);
    }
}
