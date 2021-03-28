package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @Test
    @DisplayName("match count로 랭크 찾는 테스트")
    public void valueOf() {
        // given
        Rank expectRank = Rank.FIRST;
        int matchCount = 1;

        // when
        Rank resultRank = expectRank.valueOf(matchCount);

        // then
        assertThat(resultRank).isEqualTo(expectRank);
    }

}
