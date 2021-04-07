package step4.domain.winning;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step4.domain.rank.Rank;
import step4.exception.MapNullPointerException;

import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class WinningResultTest {

    @DisplayName("WinningResult 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // given
        Map<Rank, Long> inputMap = new EnumMap<>(Rank.class);

        // when
        WinningResult winningResult = WinningResult.of(inputMap);

        // then
        assertThat(winningResult).isNotNull();
    }

    @DisplayName("WinningResult 인스턴스에 Null 주입시 예외처리 여부 테스트")
    @Test
    void 검증_Null() {
        // given
        Map<Rank, Long> inputMap = null;

        // when and then
        assertThatThrownBy(() -> WinningResult.of(inputMap))
                .isInstanceOf(MapNullPointerException.class)
                .hasMessageContaining("Map 인스턴스가 Null 입니다.");

    }

    @DisplayName("WinningResult 인스턴스가 초기 셋팅값 반환 여부 테스트")
    @Test
    void 반환_초기값() {

        // when
        Map<Rank, Long> actual = WinningResult.values();

        // when and then
        assertAll(
                () -> assertThat(actual.get(Rank.MISS)).isEqualTo(0),
                () -> assertThat(actual.get(Rank.FIFTH)).isEqualTo(0),
                () -> assertThat(actual.get(Rank.FOURTH)).isEqualTo(0),
                () -> assertThat(actual.get(Rank.THIRD)).isEqualTo(0),
                () -> assertThat(actual.get(Rank.SECOND)).isEqualTo(0),
                () -> assertThat(actual.get(Rank.FIRST)).isEqualTo(0)

        );

    }

    @DisplayName("WinningResult 인스턴스가 당첨횟수값 반환 여부 테스트")
    @ParameterizedTest(name = "루프 : {index} / 첫번째 값 : {0} / 두번째 값 : {1}")
    @MethodSource("provideRankValuesAndWinningCount")
    void 반환_당첨횟수(Rank rank, long expected) {
        // given
        Map<Rank, Long> winningMap = WinningResult.values();
        long value = 0;
        for (Rank initRank : Rank.values()) {
            winningMap.put(initRank, winningMap.get(initRank) + (++value));
        }

        // when
        WinningResult winningResult = WinningResult.of(winningMap);
        long actual = winningResult.getWinningCount(rank);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> provideRankValuesAndWinningCount() {
        return Stream.of(
                Arguments.of(Rank.MISS, 1),
                Arguments.of(Rank.FIFTH, 2),
                Arguments.of(Rank.FOURTH, 3),
                Arguments.of(Rank.THIRD, 4),
                Arguments.of(Rank.SECOND, 5),
                Arguments.of(Rank.FIRST, 6)
        );

    }


}
