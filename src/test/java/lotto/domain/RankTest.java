package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @DisplayName("일치 개수에 따른 Rank 테스트")
    @Test
    void valueOf() {
        assertThat(Rank.valueOf(6)).isEqualTo(Rank.FIRST);
        assertThat(Rank.valueOf(5)).isEqualTo(Rank.SECOND);
        assertThat(Rank.valueOf(4)).isEqualTo(Rank.THIRD);
        assertThat(Rank.valueOf(3)).isEqualTo(Rank.FOURTH);
    }
}
