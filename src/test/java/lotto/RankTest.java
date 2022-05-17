package lotto;

import lotto.model.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RankTest {
    @Test
    @DisplayName("2등 Rank 테스트")
    void Rank_2등_테스트(){
        assertThat(Rank.of(5, true)).isEqualTo(Rank.SECOND);
    }

    @Test
    @DisplayName("3등 Rank 테스트")
    void Rank_3등_테스트(){
        assertThat(Rank.of(5, false)).isEqualTo(Rank.THIRD);
    }

    @Test
    @DisplayName("NONE Rank 테스트")
    void Rank_NONE_테스트(){
        assertThat(Rank.of(-1, false)).isEqualTo(Rank.NONE);
        assertThat(Rank.of(2, false)).isEqualTo(Rank.NONE);
    }
}
