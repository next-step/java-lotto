package com.jaenyeong.mission02.lotto.domain;

import com.jaenyeong.mission02.lotto.domain.lottery.LotteryGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.jaenyeong.mission02.lotto.domain.LotteryShop.buyAutomatically;
import static com.jaenyeong.mission02.lotto.domain.LotteryShop.buyManually;
import static com.jaenyeong.mission02.lotto.domain.lottery.LotteryGame.howManyBuyGame;
import static com.jaenyeong.mission02.lotto.util.Parser.parseWinningNumbers;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("당첨 결과에 해당하는 WinningStatistics 클래스 테스트")
class WinningStatisticsTest {
    WinningNumbers winningNumbers;

    @BeforeEach
    void prepare() {
        final String winningNumber = "1, 2, 3, 4, 5, 6";
        winningNumbers = WinningNumbers.of(parseWinningNumbers(winningNumber));
    }

    @ParameterizedTest
    @MethodSource("inputStringWhatIsWinningNumbers")
    @DisplayName("WinningStatistics 객체 생성 테스트")
    void createWinningStatistics(final String givenWinNumbers) {
        final int buyPrice = 50_000;
        final int numberOfBuyGame = howManyBuyGame(buyPrice);
        final List<LotteryGame> games = buyAutomatically(numberOfBuyGame);

        final WinningNumbers winningNumbers = WinningNumbers.of(parseWinningNumbers(givenWinNumbers));

        final List<Rank> lotteryRanks = games.stream()
            .map(gameNumber -> winningNumbers.checkWinTheLotteryWithBonus(gameNumber, 1))
            .collect(Collectors.toList());

        final WinningStatistics winningStatistics = WinningStatistics.of(lotteryRanks, buyPrice);
    }

    private static Stream<Arguments> inputStringWhatIsWinningNumbers() {
        return Stream.of(
            Arguments.of("1, 2, 3, 4, 5, 6"),
            Arguments.of("7, 18, 22, 36, 44, 15"),
            Arguments.of("5, 12, 41, 13, 35, 11"),
            Arguments.of("2, 4, 5, 10, 32, 27"),
            Arguments.of("1, 9, 7, 43, 14, 28")
        );
    }

    @ParameterizedTest
    @MethodSource("inputLotteryNumbers")
    @DisplayName("당첨금 테스트")
    void checkWinningPrize(final List<List<Integer>> givenWinNumbers) {
        final int buyPrice = 5_000;
        final List<Rank> lotteryRanks = buyManually(givenWinNumbers).stream()
            .map(gameNumber -> winningNumbers.checkWinTheLotteryWithBonus(gameNumber, 1))
            .collect(Collectors.toList());

        final WinningStatistics winningStatistics = WinningStatistics.of(lotteryRanks, buyPrice);

        assertEquals(winningStatistics.getPrizeMoney(), Rank.FIRST.getWinningPrize() + Rank.FIFTH.getWinningPrize());
    }

    private static Stream<Arguments> inputLotteryNumbers() {
        return Stream.of(
            Arguments.of(Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5, 6),
                Arrays.asList(7, 18, 22, 36, 44, 15),
                Arrays.asList(5, 12, 41, 13, 35, 11),
                Arrays.asList(2, 4, 5, 10, 32, 27),
                Arrays.asList(1, 9, 7, 43, 14, 28))));
    }

    @ParameterizedTest
    @MethodSource("isNotWinningNumbers")
    @DisplayName("수익률이 본전 이하인 경우 출력 문구 확인")
    void checkPrizeTextWhenNotBreakEven(final List<List<Integer>> givenWinNumbers) {
        final int buyPrice = 5_000;
        final List<Rank> lotteryRanks = buyManually(givenWinNumbers).stream()
            .map(gameNumber -> winningNumbers.checkWinTheLotteryWithBonus(gameNumber, 1))
            .collect(Collectors.toList());
        final WinningStatistics winningStatistics = WinningStatistics.of(lotteryRanks, buyPrice);
        final String textFormatPrize = winningStatistics.getPrintFormatPrizeRate();

        assertTrue(textFormatPrize.contains("(기준이 1이기 때문에 결과적으로 손해라는 의미임)"));
    }

    private static Stream<Arguments> isNotWinningNumbers() {
        return Stream.of(
            Arguments.of(Arrays.asList(
                Arrays.asList(11, 22, 33, 14, 15, 16),
                Arrays.asList(7, 18, 22, 36, 44, 15),
                Arrays.asList(5, 12, 41, 13, 35, 11),
                Arrays.asList(24, 34, 45, 10, 32, 27),
                Arrays.asList(19, 9, 7, 43, 14, 28))));
    }
}
