package Lotto.domain;

import Lotto.exception.NotFoundRankException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class EqualLottoCntInfoTest {

    @ParameterizedTest
    @ValueSource(ints = {8,100,999})
    @DisplayName("등수를 찾을 수 없으면 예외를 던진다.")
    public void NotFoundWinningRankTest(int rank) {
        Assertions.assertThatExceptionOfType(NotFoundRankException.class).isThrownBy(
                () -> EqualLottoCntInfo.findEqualLottoInfo(rank, false)
        );
    }

    private static Stream<Arguments> winningRankInfoArgs() {
        return Stream.of(
                arguments(EqualLottoCntInfo.FOURTH, 5, 25000),
                arguments(EqualLottoCntInfo.THIRD, 2, 100000),
                arguments(EqualLottoCntInfo.SECOND, 10, 15000000),
                arguments(EqualLottoCntInfo.FIRST, 1, 2000000000)
        );
    };

    @ParameterizedTest
    @MethodSource("winningRankInfoArgs")
    @DisplayName("등수별 총 상금액을 구한다.")
    public void winningRankTotalMoneyTest(EqualLottoCntInfo equalLottoCntInfo, int count, int totalMoney) {
        Assertions.assertThat(equalLottoCntInfo.calcTotalWinningMoney(count)).isEqualTo(totalMoney);
    }

    private static Stream<Arguments> validRankTestArgs() {
        return Stream.of(
                arguments(EqualLottoCntInfo.FIRST, true),
                arguments(EqualLottoCntInfo.SECOND, true),
                arguments(EqualLottoCntInfo.THIRD, true),
                arguments(EqualLottoCntInfo.FOURTH, true),
                arguments(EqualLottoCntInfo.FIFTH, false),
                arguments(EqualLottoCntInfo.SIX, false),
                arguments(EqualLottoCntInfo.NONE, false)
        );
    };

    @ParameterizedTest
    @MethodSource("validRankTestArgs")
    @DisplayName("상금이 있는 등수만 유효한 등수다.")
    public void validRankTest(EqualLottoCntInfo winningRankInfo, boolean result) {
        Assertions.assertThat(winningRankInfo.isWinning()).isEqualTo(result);
    }

    private static Stream<Arguments> findEqualLottoInfoArgs() {
        return Stream.of(
                arguments(6, true, EqualLottoCntInfo.FIRST),
                arguments(5, true, EqualLottoCntInfo.BONUS),
                arguments(5, false, EqualLottoCntInfo.SECOND),
                arguments(4, true, EqualLottoCntInfo.THIRD),
                arguments(4, false, EqualLottoCntInfo.THIRD)
        );
    }

    @ParameterizedTest
    @MethodSource("findEqualLottoInfoArgs")
    @DisplayName("맞춘갯수에 따라 승리등수 객체를 반환한다..")
    public void findEqualLottoInfoArgsTest(int equalCnt, boolean isBonus, EqualLottoCntInfo equalLottoCntInfo) {
        Assertions.assertThat(EqualLottoCntInfo.findEqualLottoInfo(equalCnt, isBonus)).isEqualTo(equalLottoCntInfo);
    }
}