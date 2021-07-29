package lotto.domain.prize;

import lotto.domain.money.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoPrizeTest {
    @DisplayName("당첨된 갯수를 넘겨주면 해당하는 등수를 반환한다.")
    @MethodSource
    @ParameterizedTest
    void should_return_prize_match_count(int matchCount, LottoPrize expectedLottoPrize) {
        //arrange, act, assert
        assertThat(LottoPrize.of(matchCount)).isEqualTo(expectedLottoPrize);
    }

    private static Stream<Arguments> should_return_prize_match_count() {
        return Stream.of(
                Arguments.of(6, LottoPrize.FIRST),
                Arguments.of(5, LottoPrize.SECOND),
                Arguments.of(4, LottoPrize.THIRD),
                Arguments.of(3, LottoPrize.FOURTH),
                Arguments.of(2, LottoPrize.NONE),
                Arguments.of(1, LottoPrize.NONE),
                Arguments.of(0, LottoPrize.NONE)
        );
    }

    @DisplayName("상금 있는 등수만 반환")
    @Test
    void should_get_winning_prize() {
        //arrange
        List<LottoPrize> winningPrizes = LottoPrize.getWinningPrizes();

        //act, assert
        assertAll(
                () -> assertThat(winningPrizes).doesNotContain(LottoPrize.NONE),
                () -> assertThat(winningPrizes.size()).isNotZero()
        );
    }

    @DisplayName("등수별 상금  테스트")
    @MethodSource
    @ParameterizedTest
    void should_get_prize_money_amount(LottoPrize lottoPrize, int expectedValue) {
        //arrange, act, assert
        assertThat(lottoPrize.getPrizeMoneyAmount()).isEqualTo(expectedValue);
    }

    private static Stream<Arguments> should_get_prize_money_amount() {
        return Stream.of(
                Arguments.of(LottoPrize.FIRST, 2_000_000_000),
                Arguments.of(LottoPrize.SECOND, 1_500_000),
                Arguments.of(LottoPrize.THIRD, 50_000),
                Arguments.of(LottoPrize.FOURTH, 5_000),
                Arguments.of(LottoPrize.NONE, 0)
        );
    }

    @DisplayName("등수별 상금 테스트")
    @MethodSource
    @ParameterizedTest
    void should_get_prize_money(LottoPrize lottoPrize, Money expectedValue) {
        //arrange, act, assert
        assertThat(lottoPrize.getPrizeMoney()).isEqualTo(expectedValue);
    }

    private static Stream<Arguments> should_get_prize_money() {
        return Stream.of(
                Arguments.of(LottoPrize.FIRST, Money.of(2_000_000_000)),
                Arguments.of(LottoPrize.SECOND, Money.of(1_500_000)),
                Arguments.of(LottoPrize.THIRD, Money.of(50_000)),
                Arguments.of(LottoPrize.FOURTH, Money.of(5_000)),
                Arguments.of(LottoPrize.NONE, Money.of(0))
        );
    }
}