package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;


class RankTest {
    @ParameterizedTest(name = "matchCount = {0}, bonus = {1}")
    @CsvSource(value = {"6 : false"}, delimiter = ':')
    @DisplayName("1등 확인(6개 일치) 테스트")
    void first_rank_test(int matchCount, boolean isBonus) {
        Rank rank = Rank.of(matchCount, isBonus);
        assertThat(rank).isEqualTo(Rank.FIRST);
    }

    @ParameterizedTest(name = "matchCount = {0}, bonus = {1}")
    @CsvSource(value = {"5 : true"}, delimiter = ':')
    @DisplayName("2등 확인(5개 일치) 테스트")
    void second_rank_test(int matchCount, boolean isBonus) {
        Rank rank = Rank.of(matchCount, isBonus);
        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @ParameterizedTest(name = "matchCount = {0}, bonus = {1}")
    @CsvSource(value = {"5 : false"}, delimiter = ':')
    @DisplayName("3등 확인(5개 일치) 테스트")
    void third_rank_test(int matchCount, boolean isBonus) {
        Rank rank = Rank.of(matchCount, isBonus);
        assertThat(rank).isEqualTo(Rank.THIRD);
    }

    @ParameterizedTest(name = "matchCount = {0}, bonus = {1}")
    @CsvSource(value = {"4 : false"}, delimiter = ':')
    @DisplayName("4등 확인(4개 일치) 테스트")
    void fouth_rank_test(int matchCount, boolean isBonus) {
        Rank rank = Rank.of(matchCount, isBonus);
        assertThat(rank).isEqualTo(Rank.FOURTH);
    }

    @ParameterizedTest(name = "matchCount = {0}, bonus = {1}")
    @CsvSource(value = {"3 : false"}, delimiter = ':')
    @DisplayName("5등 확인(3개 일치) 테스트")
    void fifth_rank_test(int matchCount, boolean isBonus) {
        Rank rank = Rank.of(matchCount, isBonus);
        assertThat(rank).isEqualTo(Rank.FIFTH);
    }

    @ParameterizedTest(name = "matchCount = {0}, bonus = {1}")
    @CsvSource(value = {"0 : false"}, delimiter = ':')
    @DisplayName("3개 미만 확인 테스트")
    void null_rank_test(int matchCount, boolean isBonus) {
        Rank rank = Rank.of(matchCount, isBonus);
        assertThat(rank).isEqualTo(Rank.MISS);
    }
}
