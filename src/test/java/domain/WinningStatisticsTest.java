package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class WinningStatisticsTest {

    @MethodSource("provideWinningNumbers")
    @ParameterizedTest
    public void 로또_결과를_입력받으면_매칭_결과를_반환한다(List<Integer> winningNumbers, List<List<Integer>> prizes, int bonusNumber) {
        //given
        WinningStatistics winningStatistics = WinningStatistics.of(winningNumbers, bonusNumber);

        LottoResult fifthPrizes = LottoResult.fromIntegers(prizes.get(0));
        LottoResult fourthPrizes = LottoResult.fromIntegers(prizes.get(1));
        LottoResult thirdPrizes = LottoResult.fromIntegers(prizes.get(2));
        LottoResult secondPrizes = LottoResult.fromIntegers(prizes.get(3));
        LottoResult firstPrizes = LottoResult.fromIntegers(prizes.get(4));

        //when
        winningStatistics.matchCount(fifthPrizes);
        winningStatistics.matchCount(fourthPrizes);
        winningStatistics.matchCount(thirdPrizes);
        winningStatistics.matchCount(secondPrizes);
        winningStatistics.matchCount(firstPrizes);

        //then
        assertThat(winningStatistics.getWinningResults().get(WinningPrizeMatcher.THREE)).isEqualTo(1);
        assertThat(winningStatistics.getWinningResults().get(WinningPrizeMatcher.FOUR)).isEqualTo(1);
        assertThat(winningStatistics.getWinningResults().get(WinningPrizeMatcher.FIVE)).isEqualTo(1);
        assertThat(winningStatistics.getWinningResults().get(WinningPrizeMatcher.FIVE_BONUS)).isEqualTo(1);
        assertThat(winningStatistics.getWinningResults().get(WinningPrizeMatcher.SIX)).isEqualTo(1);

        assertThat(winningStatistics.getTotalWinnings()).isEqualTo(2004555000);

    }

    private static Stream<Arguments> provideWinningNumbers() {
        return Stream.of(
            Arguments.of(
                Arrays.asList(1, 3, 15, 17, 21, 35),
                Arrays.asList(
                    Arrays.asList(1, 3, 15, 7, 9, 11), // 3개 일치
                    Arrays.asList( 1, 3, 15, 17, 9, 11 ), // 4개 일치
                    Arrays.asList( 1, 3, 15, 17, 9, 21 ), // 5개 일치
                    Arrays.asList(1, 3, 15, 17, 21, 22), // 5개 일치 & 보너스 일치
                    Arrays.asList( 1, 3, 15, 17, 21, 35 ) // 6개 일치
                ),
                22 // 보너스
            )
        );
    }
}
