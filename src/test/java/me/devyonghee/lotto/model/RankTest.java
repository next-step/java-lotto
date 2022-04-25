package me.devyonghee.lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("순위")
class RankTest {

    @ParameterizedTest
    @DisplayName("매칭 갯수로 순위 조회")
    @CsvSource({"6,FIRST", "5,SECOND", "4,THIRD", "3,FOURTH", "2,NOTING"})
    void rank(int count, Rank expected) {
        assertThat(Rank.of(count)).isEqualTo(expected);
    }
}
