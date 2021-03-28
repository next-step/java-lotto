package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @Test
    public void valueOfFirst() {
        // given
        Rank expectRank = Rank.FIRST;
        int matchCount = 6;

        // when
        Rank resultRank = expectRank.valueOf(matchCount);

        // then
        assertThat(resultRank).isEqualTo(expectRank);
    }

    @Test
    public void valueOfOther() {
        // given
        Rank expectRank = Rank.OTHER;
        int matchCount = 1;

        // when
        Rank resultRank = expectRank.valueOf(matchCount);

        // then
        assertThat(resultRank).isEqualTo(expectRank);
    }

}
