package lotto.domain.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RankTest {

    @DisplayName("일치 개수와 bonus 일치에 따른 Rank")
    @ParameterizedTest
    @MethodSource(value = "provideMatchInfoAndRank")
    void create(int matchCount, boolean bonusMath, Rank rank) {
        assertThat(Rank.valueOf(matchCount, bonusMath)).isEqualTo(rank);
    }

    private static Stream<Arguments> provideMatchInfoAndRank() {
        return Stream.of(
                Arguments.of(6, true, Rank.FIRST),
                Arguments.of(6, false, Rank.FIRST),
                Arguments.of(5, true, Rank.SECOND),
                Arguments.of(5, false, Rank.THIRD),
                Arguments.of(4, true, Rank.FOURTH),
                Arguments.of(4, false, Rank.FOURTH),
                Arguments.of(3, true, Rank.FIFTH),
                Arguments.of(3, false, Rank.FIFTH),
                Arguments.of(2, true, Rank.ETC),
                Arguments.of(2, false, Rank.ETC),
                Arguments.of(0, true, Rank.ETC),
                Arguments.of(0, false, Rank.ETC)
        );
    }

    @DisplayName("일치 개수에 따른 Rank(일치 개수가 6개 초과_실패)")
    @Test
    void create_over_match_count_fail() {
        assertThatThrownBy(() -> Rank.valueOf(7, false))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("일치 개수는 6개 초과일 수 없습니다.");
    }

    @DisplayName("일치 개수에 따른 Rank(일치 개수가 음수_실패)")
    @Test
    void create_negative_match_count_fail() {
        assertThatThrownBy(() -> Rank.valueOf(-1, false))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("일치 개수는 음수일 수 없습니다.");
    }

}
