package me.devyonghee.lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DisplayName("점수")
class ScoreTest {

    @Test
    @DisplayName("객체화")
    void instance() {
        assertThatNoException().isThrownBy(() -> Score.from(Collections.singleton(Rank.FIRST)));
    }

    @Test
    @DisplayName("순위들은 필수")
    void instance_nullRanks_thrownNullPointerException() {
        assertThatNullPointerException().isThrownBy(() -> Score.from(null));
    }

    @ParameterizedTest(name = "[{index}] {0} 의 갯수는 {1}")
    @DisplayName("순위들 개수 세기")
    @CsvSource({"FIRST,1", "SECOND,2", "THIRD,3", "FOURTH,4", "NOTHING,0"})
    void count(Rank target, int expected) {
        //given
        List<Rank> ranks = Arrays.asList(
                Rank.FIRST,
                Rank.SECOND, Rank.SECOND,
                Rank.THIRD, Rank.THIRD, Rank.THIRD,
                Rank.FOURTH, Rank.FOURTH, Rank.FOURTH, Rank.FOURTH);
        //when, then
        assertThat(Score.from(ranks).count(target)).isEqualTo(expected);
    }

    @Test
    @DisplayName("순위들 개수 세기")
    void profitRatio() {
        //given
        List<Rank> ranks = Arrays.asList(Rank.FOURTH, Rank.NOTHING, Rank.NOTHING, Rank.NOTHING, Rank.NOTHING);
        //when, then
        assertThat(Score.from(ranks).profitRatio()).isEqualByComparingTo(BigDecimal.ONE);
    }
}
