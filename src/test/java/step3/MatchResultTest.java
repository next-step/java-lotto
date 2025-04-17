package step3;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step3.domain.MatchResult;
import step3.domain.Rank;

public class MatchResultTest {
    @Test
    @DisplayName("2등과 3등 차이")
    void bonusBallTest() {
        MatchResult secondPlace = new MatchResult(5, true);
        MatchResult thirdPlace = new MatchResult(5, false);
        assertAll(
            () -> assertThat(Rank.of(secondPlace)).isEqualTo(Rank.SECOND),
            () -> assertThat(Rank.of(thirdPlace)).isEqualTo(Rank.THIRD)
        );

    }
}
