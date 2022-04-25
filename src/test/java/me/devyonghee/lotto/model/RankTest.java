package me.devyonghee.lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("순위")
class RankTest {

    @ParameterizedTest
    @DisplayName("매칭 갯수로 순위 조회")
    @CsvSource({"6,FIRST", "5,SECOND", "4,THIRD", "3,FOURTH", "2,NOTHING"})
    void rank(int count, Rank expected) {
        assertThat(Rank.of(count)).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("매칭 갯수 조회")
    @CsvSource({"FIRST,6", "SECOND,5", "THIRD,4", "FOURTH,3", "NOTHING,0"})
    void matchCount(Rank rank, int count) {
        assertThat(rank.matchCount()).isEqualTo(count);
    }

    @ParameterizedTest
    @DisplayName("상금 조회")
    @CsvSource({"FIRST,2_000_000_000", "SECOND,1_500_000", "THIRD,50_000", "FOURTH,5_000", "NOTHING,0"})
    void prize(Rank rank, int prize) {
        assertThat(rank.prize()).isEqualTo(prize);
    }
}
