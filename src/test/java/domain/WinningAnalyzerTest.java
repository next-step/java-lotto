package domain;

import static domain.WinningStatistics.WINNING_PRIZES;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class WinningAnalyzerTest {


    @MethodSource("provideLottoList")
    @ParameterizedTest
    public void 지난주_당첨번호를_입력하면_당첨통계를_제공한다(List<int[]> lottoList, List<Integer> winningNumbers) throws Exception {
        //given
        LottoResults lottoResults = new LottoResults(lottoList);
        WinningAnalyzer winningAnalyzer = new WinningAnalyzer(lottoResults, winningNumbers);
        //when
        WinningStatistics winningStatistics = winningAnalyzer.calculateWinningStatistics();
        int[] result = winningStatistics.getWinningResults();
        //then
        assertThat(result[0]).isEqualTo(1);
        assertThat(result[1]).isEqualTo(1);
        assertThat(result[2]).isEqualTo(1);
        assertThat(result[3]).isEqualTo(1);
    }

    @MethodSource("provideLottoList")
    @ParameterizedTest
    void 수익률을_반환한다(List<int[]> lottoList, List<Integer> winningNumbers) {
        //given
        LottoResults lottoResults = new LottoResults(lottoList);
        WinningAnalyzer winningAnalyzer = new WinningAnalyzer(lottoResults, winningNumbers);
        WinningStatistics winningStatistics = winningAnalyzer.calculateWinningStatistics();

        //when
        float roi = winningAnalyzer.getReturnOnInvestment(7000);
        float expectedResult = WINNING_PRIZES.stream().mapToInt(prize -> prize.getPrizeMoney()).sum() / 7000;

        //then
        assertThat(areFloatsEqual(roi, expectedResult)).isTrue();
    }
    private static Stream<Arguments> provideLottoList() {
        return Stream.of(
            Arguments.of(
                Arrays.asList(
                    new int[]{ 2, 4, 6, 7, 10, 12 },
                    new int[]{ 1, 4, 6, 7, 10, 12 },
                    new int[]{ 1, 2, 3, 4, 5, 6 },
                    new int[]{ 1, 4, 5, 6, 15, 17 },
                    new int[]{ 1, 3, 15, 17, 18, 19 },
                    new int[]{ 1, 3, 15, 17, 29, 30 },
                    new int[]{ 1, 3, 15, 17, 29, 31 }
                ),
                Arrays.asList(1, 3, 15, 17, 29, 31)
            )
        );
    }

    private static boolean areFloatsEqual(float a, float b) {
        float epsilon = 1f;
        return Math.abs(a - b) <= epsilon;
    }


}
