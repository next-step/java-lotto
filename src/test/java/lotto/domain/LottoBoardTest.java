package lotto.domain;

import lotto.domain.enums.Rank;
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
    void board_초기값(Rank input, int expected) {
        LottoBoard lottoBoard = new LottoBoard();
        assertThat(lottoBoard.getBoard().get(input)).isEqualTo(expected);
    }

    private static Stream<Arguments> provideLottoMatcherInit() {
        return Stream.of(
                Arguments.of(Rank.MISS, 0),
                Arguments.of(Rank.FIFTH, 0),
                Arguments.of(Rank.FOURTH, 0),
                Arguments.of(Rank.THIRD, 0),
                Arguments.of(Rank.SECOND, 0),
                Arguments.of(Rank.FIRST, 0)
        );
    }


    @DisplayName("로또 카운트 매치시 보드의 카운트가 올라가는지 테스트")
    @ParameterizedTest
    @MethodSource("provideLottoMatcherCountOne")
    void calculate_테스트(Rank input, int expected) {
        LottoBoard lottoBoard = new LottoBoard();
        lottoBoard.calculate(input);
        assertThat(lottoBoard.getBoard().get(input)).isEqualTo(expected);
    }

    private static Stream<Arguments> provideLottoMatcherCountOne() {
        return Stream.of(
                Arguments.of(Rank.MISS, 1),
                Arguments.of(Rank.FIFTH, 1),
                Arguments.of(Rank.FOURTH, 1),
                Arguments.of(Rank.THIRD, 1),
                Arguments.of(Rank.SECOND, 1),
                Arguments.of(Rank.FIRST, 1)
        );
    }

    @DisplayName("로또 수익률 테스트")
    @ParameterizedTest
    @MethodSource("provideLottoMatcherForWinntingRatio")
    void calculateWinningRatioTest(Rank[] lottoMatchers, double expected) {
        LottoBoard lottoBoard = new LottoBoard();
        for (Rank lottoMatcher : lottoMatchers) {
            lottoBoard.calculate(lottoMatcher);
        }

        assertThat(lottoBoard.getWinningRatio()).isEqualTo(expected);
     }
    private static Stream<Arguments> provideLottoMatcherForWinntingRatio() {
        return Stream.of(
                Arguments.of(new Rank[] {Rank.MISS, Rank.MISS, Rank.MISS, Rank.FIFTH}, 1.25),
                Arguments.of(new Rank[] {Rank.MISS, Rank.MISS, Rank.MISS, Rank.THIRD}, 375.0),
                Arguments.of(new Rank[] {Rank.MISS, Rank.MISS, Rank.MISS, Rank.MISS, Rank.FOURTH}, 10.0)
        );
    }
}
