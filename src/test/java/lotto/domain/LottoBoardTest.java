package lotto.domain;

import lotto.domain.enums.LottoMatcher;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoBoardTest {

    @DisplayName("로또 카운트 매치시 보드의 카운트가 올라가는지 테스트")
    @ParameterizedTest
    @MethodSource("provideLottoMatcherInit")
    void board_초기값(LottoMatcher input, int expected) {
        LottoBoard lottoBoard = new LottoBoard();
        assertThat(lottoBoard.getBoard().get(input)).isEqualTo(expected);
    }

    private static Stream<Arguments> provideLottoMatcherInit() {
        return Stream.of(
                Arguments.of(LottoMatcher.MATCH_ZERO, 0),
                Arguments.of(LottoMatcher.MATCH_THREE, 0),
                Arguments.of(LottoMatcher.MATCH_FOUR, 0),
                Arguments.of(LottoMatcher.MATCH_FIVE, 0),
                Arguments.of(LottoMatcher.MATCH_SIX, 0)
        );
    }


    @DisplayName("로또 카운트 매치시 보드의 카운트가 올라가는지 테스트")
    @ParameterizedTest
    @MethodSource("provideLottoMatcherCountOne")
    void calculate_테스트(LottoMatcher input, int expected) {
        LottoBoard lottoBoard = new LottoBoard();
        lottoBoard.calculate(input);
        assertThat(lottoBoard.getBoard().get(input)).isEqualTo(expected);
    }

    private static Stream<Arguments> provideLottoMatcherCountOne() {
        return Stream.of(
                Arguments.of(LottoMatcher.MATCH_ZERO, 1),
                Arguments.of(LottoMatcher.MATCH_THREE, 1),
                Arguments.of(LottoMatcher.MATCH_FOUR, 1),
                Arguments.of(LottoMatcher.MATCH_FIVE, 1),
                Arguments.of(LottoMatcher.MATCH_SIX, 1)
        );
    }

    @DisplayName("로또 수익률 테스트")
    @ParameterizedTest
    @MethodSource("provideLottoMatcherForWinntingRatio")
    void calculateWinningRatioTest(LottoMatcher[] lottoMatchers, double expected) {
        LottoBoard lottoBoard = new LottoBoard();
        for (LottoMatcher lottoMatcher : lottoMatchers) {
            lottoBoard.calculate(lottoMatcher);
        }

        assertThat(lottoBoard.getWinningRatio()).isEqualTo(expected);
     }
    private static Stream<Arguments> provideLottoMatcherForWinntingRatio() {
        return Stream.of(
                Arguments.of(new LottoMatcher[] {LottoMatcher.MATCH_ZERO, LottoMatcher.MATCH_ZERO, LottoMatcher.MATCH_ZERO, LottoMatcher.MATCH_THREE}, 0.5555555555555556),
                Arguments.of(new LottoMatcher[] {LottoMatcher.MATCH_ZERO, LottoMatcher.MATCH_ZERO, LottoMatcher.MATCH_ZERO, LottoMatcher.MATCH_FIVE}, 166.66666666666666),
                Arguments.of(new LottoMatcher[] {LottoMatcher.MATCH_ZERO, LottoMatcher.MATCH_ZERO, LottoMatcher.MATCH_ZERO, LottoMatcher.MATCH_ZERO, LottoMatcher.MATCH_FOUR}, 5.0)
        );
    }
}
