package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @DisplayName("정상 생성 테스트")
    @Test
    void valueOf() {
        assertThat(Rank.valueOf(4, false)).isEqualTo(Rank.FIFTH);
        assertThat(Rank.valueOf(4, true)).isEqualTo(Rank.FIFTH);
    }

    @DisplayName("보너스가 true인 경우 2등")
    @Test
    void valueOfSecond() {
        assertThat(Rank.valueOf(5, true)).isEqualTo(Rank.SECOND);
    }

    @DisplayName("보너스가 false인 경우 3등")
    @Test
    void valueOfThird() {
        assertThat(Rank.valueOf(5, false)).isEqualTo(Rank.THIRD);
    }

}
