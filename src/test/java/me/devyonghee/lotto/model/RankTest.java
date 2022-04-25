package me.devyonghee.lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("순위")
class RankTest {

    @ParameterizedTest
    @DisplayName("매칭 갯수로 순위 조회")
    @CsvSource({"6,false,FIRST", "5,true,SECOND", "5,false,THIRD", "4,true,FOURTH", "4,false,FOURTH", "3,true,FIFTH", "3,false,FIFTH", "2,true,NOTHING", "1,true,NOTHING"})
    void rank(int count, boolean hasBonus, Rank expected) {
        assertThat(Rank.of(count, hasBonus)).isEqualTo(expected);
    }

    @Test
    @DisplayName("존재하지 않는 경우에는 IllegalArgumentException")
    void rank_invalidCount_thrownIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> Rank.of(Integer.MAX_VALUE, false));
    }

    @ParameterizedTest
    @DisplayName("매칭 갯수 조회")
    @CsvSource({"FIRST,6", "SECOND,5", "THIRD,5", "FOURTH,4", "FIFTH,3"})
    void matchCount(Rank rank, int expected) {
        assertThat(rank.matchCount()).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("상금 조회")
    @CsvSource({"FIRST,2_000_000_000", "SECOND,30_000_000", "THIRD,1_500_000", "FOURTH,50_000", "FIFTH,5_000", "NOTHING,0"})
    void prize(Rank rank, int expected) {
        assertThat(rank.prize()).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("상금 조회")
    @CsvSource({"FIRST,false", "SECOND,true", "THIRD,false", "FOURTH,false", "FIFTH,false", "NOTHING,false"})
    void prize(Rank rank, boolean expected) {
        assertThat(rank.matchedBonus()).isEqualTo(expected);
    }
}
