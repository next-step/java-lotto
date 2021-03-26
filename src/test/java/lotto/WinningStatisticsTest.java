package lotto;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static lotto.LottoFixture.*;

public class WinningStatisticsTest {

    @Test
    void testConstructor() {
        Lotto winningNumber = new Lotto(Lists.newArrayList(1, 2, 3, 4, 5, 6));
        List<Lotto> lottoList = LottoStore.issue(String.valueOf(10000));
        WinningStatistics statistics = new WinningStatistics(winningNumber, lottoList);
        Assertions.assertThat(statistics)
                .hasFieldOrProperty("winningLogs");
    }

    @ParameterizedTest
    @MethodSource("providerTestWinningLogs")
    void testWinningLogs(Lotto winningNumber, List<Lotto> lottoList, WinningStatistics expected) {
        WinningStatistics statistics = new WinningStatistics(winningNumber, lottoList);
        Assertions.assertThat(statistics)
                .isEqualTo(expected);
    }

    static Stream<Arguments> providerTestWinningLogs() {
        WinningStatistics 일치_없음 = WinningStatisticsFixture.by(0, 0, 0, 0);
        WinningStatistics 일등_2_삼등_1_사등_3_오등_1 =
                WinningStatisticsFixture.by(2, 1, 3, 1);

        return Stream.of(
                Arguments.of(WINNING_NUMBER, Lists.newArrayList(NONE_MATCHED, ONE_MATCHED, TWO_MATCHED), 일치_없음),
                Arguments.of(WINNING_NUMBER,
                        Lists.newArrayList(ALL_MATCHED,
                                ALL_MATCHED,
                                FIVE_MATCHED,
                                FOUR_MATCHED,
                                FOUR_MATCHED,
                                FOUR_MATCHED,
                                THREE_MATCHED
                        ),
                        일등_2_삼등_1_사등_3_오등_1));
    }

    @ParameterizedTest
    @MethodSource("providerTestReturnOnInvestment")
    void testReturnOnInvestment(Lotto WINNING_NUMBER, List<Lotto> purchased, float expectedReturnOnInvestment) {
        WinningStatistics statistics = new WinningStatistics(WINNING_NUMBER, purchased);
        Assertions.assertThat(statistics.returnOnInvestment())
                .isEqualTo(expectedReturnOnInvestment);
    }

    static Stream<Arguments> providerTestReturnOnInvestment() {
        return Stream.of(
                Arguments.of(WINNING_NUMBER, Lists.newArrayList(ALL_MATCHED), 2000000f),
                Arguments.of(WINNING_NUMBER, Lists.newArrayList(NONE_MATCHED), 0f),
                Arguments.of(
                        WINNING_NUMBER,
                        Lists.newArrayList(
                                NONE_MATCHED,
                                NONE_MATCHED,
                                ONE_MATCHED,
                                TWO_MATCHED,
                                THREE_MATCHED
                        ),
                        1f),
                Arguments.of(
                        WINNING_NUMBER,
                        Lists.newArrayList(
                                NONE_MATCHED,
                                NONE_MATCHED,
                                NONE_MATCHED,
                                NONE_MATCHED,
                                NONE_MATCHED,
                                NONE_MATCHED,
                                NONE_MATCHED,
                                NONE_MATCHED,
                                NONE_MATCHED,
                                NONE_MATCHED,
                                NONE_MATCHED,
                                NONE_MATCHED,
                                NONE_MATCHED,
                                THREE_MATCHED
                                ),
                        0.35f)
                );
    }

}
