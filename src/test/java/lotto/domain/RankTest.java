package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @DisplayName("일치 개수로 Rank를 정상 반환한다")
    @ParameterizedTest
    @CsvSource({
            "3, THREE",
            "4, FOUR",
            "5, FIVE",
            "6, SIX"
    })
    void rank(int matchCount, Rank expected) {
        assertThat(Rank.from(matchCount)).isEqualTo(expected);
    }

    @DisplayName("일치 개수가 없으면 빈 Optional을 반환한다")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 7, 10})
    void empty_rank(int matchCount) {
        assertThat(Rank.from(matchCount)).isEqualTo(Rank.NONE);
    }
}
