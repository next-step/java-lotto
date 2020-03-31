package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.Rank.FIRST;
import static lotto.Rank.SECOND;
import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @Test
    @DisplayName("일치하는 번호 갯수를 랭킹으로 변경한다")
    public void getRankReturnsRank() {
        Rank rank = Rank.of(6);

        assertThat(rank).isEqualTo(FIRST);

        rank = Rank.of(5);

        assertThat(rank).isEqualTo(SECOND);
    }
}
