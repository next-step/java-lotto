package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RankTest {
    @Test
    @DisplayName("enum equals 학습 테스트")
    public void rankTest() {
        assertThat(Rank.fiveNumbersMatch).isEqualTo(Rank.fiveNumbersMatch);
        assertThat(Rank.fiveNumbersMatch == Rank.fiveNumbersMatch).isTrue();
    }
}
