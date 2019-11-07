package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by yusik on 2019/11/08.
 */
class WinningRankingTest {

    @Test
    void getMatchingCount() {

        // given
        int expected = 6;
        WinningRanking ranking = WinningRanking.FIRST;

        // when
        int result = ranking.getMatchingCount();

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void getReward() {

        // given
        int expected = 2_000_000_000;
        WinningRanking ranking = WinningRanking.FIRST;

        // when
        int result = ranking.getReward();

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void hasBonus() {

        // given
        WinningRanking ranking = WinningRanking.SECOND;

        // when
        boolean result = ranking.hasBonus();

        // then
        assertThat(result).isTrue();
    }

    @Test
    void valuable() {

        // given
        WinningRanking ranking = WinningRanking.MISS;

        // when
        boolean result = ranking.valuable();

        // then
        assertThat(result).isFalse();
    }

    @Test
    void valueOf() {

        // given
        WinningRanking expected = WinningRanking.MISS;

        // when
        WinningRanking result = WinningRanking.valueOf(0, false);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void sortedValues() {

        // given
        WinningRanking expected = WinningRanking.FIFTH;

        // when
        WinningRanking result = WinningRanking.sortedValues().stream()
                .findFirst()
                .orElse(WinningRanking.MISS);

        // then
        assertThat(result).isEqualTo(expected);
    }
}