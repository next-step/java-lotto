package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class WinningStatisticsTest {

    @MethodSource("provideWinningNumbers")
    @ParameterizedTest
    public void 로또_결과를_입력받으면_매칭_결과를_반환한다(List<Integer> winningNumbers, List<int[]> prizes) {
        //given
        WinningStatistics winningStatistics = new WinningStatistics(winningNumbers);

        LottoNumber[] fourthPrizes = LottoNumber.fromIntegers(prizes.get(0));
        LottoNumber[] thirdPrizes = LottoNumber.fromIntegers(prizes.get(1));
        LottoNumber[] secondPrizes = LottoNumber.fromIntegers(prizes.get(2));
        LottoNumber[] firstPrizes = LottoNumber.fromIntegers(prizes.get(3));

        //when
        winningStatistics.matchCount(fourthPrizes);
        winningStatistics.matchCount(thirdPrizes);
        winningStatistics.matchCount(secondPrizes);
        winningStatistics.matchCount(firstPrizes);

        //then
        assertThat(winningStatistics.getWinningResults()[0]).isEqualTo(1);
        assertThat(winningStatistics.getWinningResults()[1]).isEqualTo(1);
        assertThat(winningStatistics.getWinningResults()[2]).isEqualTo(1);
        assertThat(winningStatistics.getWinningResults()[3]).isEqualTo(1);
        assertThat(winningStatistics.getTotalWinnings()).isEqualTo(2001555000);

    }

    private static Stream<Arguments> provideWinningNumbers() {
        return Stream.of(
            Arguments.of(
                Arrays.asList(1, 3, 15, 17, 21, 35),
                Arrays.asList(
                    new int[]{ 1, 3, 15, 7, 9, 11 },
                    new int[]{ 1, 3, 15, 17, 9, 11 },
                    new int[]{ 1, 3, 15, 17, 9, 21 },
                    new int[]{ 1, 3, 15, 17, 21, 35 }
                )
            )
        );
    }
}
