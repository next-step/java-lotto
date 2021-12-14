package lottery.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MatchedCountAndPrizePairTest {

    @Test
    @DisplayName("생성 테스트")
    void generationTest() {
        final int matchedCount = 3;
        final int prize = 5000;

        final MatchedCountAndPrizePair matchedCountAndPrizePair = MatchedCountAndPrizePair.of(matchedCount, prize);

        assertThat(matchedCountAndPrizePair.matchedCount()).isEqualTo(matchedCount);
        assertThat(matchedCountAndPrizePair.prize()).isEqualTo(prize);
    }
}
