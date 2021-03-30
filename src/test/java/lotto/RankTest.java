package lotto;

import lotto.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RankTest {
    @DisplayName("맞춘 개수에 따른 결과(Rank) 반환")
    @Test
    void converterPrize() {
        // GIVE
        Rank rank = Rank.converterPrize(6);
        // WHEN
        // THAN
        assertThat(rank).isEqualTo(Rank.FIRST);

    }

    @DisplayName("범위에 벗어난 개수를 넣을 때 IllegalArgumentException 발생")
    @Test
    void converterPrizeException() {
        // GIVE
        // WHEN
        // THAN
        assertThatThrownBy(() -> Rank.converterPrize(8))
                .isInstanceOf(IllegalArgumentException.class);

    }
}
