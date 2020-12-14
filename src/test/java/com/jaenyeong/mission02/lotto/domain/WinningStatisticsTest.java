package com.jaenyeong.mission02.lotto.domain;

import com.jaenyeong.mission02.lotto.domain.lottery.LotteryGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.jaenyeong.mission02.lotto.domain.LotteryShop.buyAutomatically;
import static com.jaenyeong.mission02.lotto.domain.lottery.LotteryGame.howManyBuyGame;
import static com.jaenyeong.mission02.lotto.util.Parser.parseWinningNumbers;

@DisplayName("당첨 결과에 해당하는 WinningStatistics 클래스 테스트")
class WinningStatisticsTest {

    @ParameterizedTest
    @MethodSource("inputStringWhatIsWinningNumbers")
    @DisplayName("WinningStatistics 객체 생성 테스트")
    void createWinningStatistics(final String givenWinNumbers) {
        final int buyPrice = 50_000;
        final int numberOfBuyGame = howManyBuyGame(buyPrice);
        final List<LotteryGame> games = buyAutomatically(numberOfBuyGame);

        final WinningNumbers winningNumbers = WinningNumbers.of(parseWinningNumbers(givenWinNumbers));

        final List<Rank> lotteryRanks = games.stream()
            .map(winningNumbers::checkWinTheLottery)
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
}
