package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PrizeTest {

    @ParameterizedTest
    @MethodSource("provideMatchCountAndMatchBonus")
    @DisplayName("일치하는 개수와 보너스 여부에 따른 등수 확인")
    void valueOf(long matchCount, boolean matchBonus, Prize expected) {
        assertEquals(expected, Prize.valueOf(matchCount, matchBonus));
    }

    private static Stream<Arguments> provideMatchCountAndMatchBonus() {
        return Stream.of(
                Arguments.of(1, true, Prize.ETC),
                Arguments.of(1, false, Prize.ETC),
                Arguments.of(2, true, Prize.ETC),
                Arguments.of(2, false, Prize.ETC),
                Arguments.of(3, true, Prize.FIFTH),
                Arguments.of(3, false, Prize.FIFTH),
                Arguments.of(4, true, Prize.FOURTH),
                Arguments.of(4, false, Prize.FOURTH),
                Arguments.of(5, true, Prize.SECOND),
                Arguments.of(5, false, Prize.THIRD),
                Arguments.of(6, true, Prize.FIRST),
                Arguments.of(6, false, Prize.FIRST)
        );
    }

    @Test
    @DisplayName("상금이 존재하는 순서 반환")
    void valuesOfWin() {
        assertThat(Prize.valuesOfWin()).containsAll(Arrays.asList(
                Prize.FIFTH, Prize.FOURTH, Prize.THIRD, Prize.SECOND, Prize.FIRST
        ));
    }

    @Test
    @DisplayName("순위에 따른 일치 개수 확인")
    void getMatchCount() {
        assertEquals(Prize.ETC.getMatchCount(), 0);
        assertEquals(Prize.FIFTH.getMatchCount(), 3);
        assertEquals(Prize.FOURTH.getMatchCount(), 4);
        assertEquals(Prize.THIRD.getMatchCount(), 5);
        assertEquals(Prize.SECOND.getMatchCount(), 5);
        assertEquals(Prize.FIRST.getMatchCount(), 6);
    }

    @Test
    @DisplayName("순위에 따른 보상금 확인")
    void getReward() {
        assertEquals(Prize.ETC.getReward(), 0);
        assertEquals(Prize.FIFTH.getReward(), 5_000);
        assertEquals(Prize.FOURTH.getReward(), 50_000);
        assertEquals(Prize.THIRD.getReward(), 1_500_000);
        assertEquals(Prize.SECOND.getReward(), 30_000_000);
        assertEquals(Prize.FIRST.getReward(), 2_000_000_000);
    }
}
