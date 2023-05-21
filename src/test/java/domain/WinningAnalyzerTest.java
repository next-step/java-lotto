package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class WinningAnalyzerTest {

    @MethodSource("provideLottoList")
    @ParameterizedTest
    public void 지난주_당첨번호를_입력하면_당첨통계를_제공한다(List<Set<Integer>> lottosList, Set<Integer> winningNumbers, int bonusNumber) throws Exception {
        //given
        LottoResults lottoResults = LottoResults.fromIntegers(lottosList);
        WinningAnalyzer winningAnalyzer = new WinningAnalyzer(lottoResults, winningNumbers, bonusNumber);
        //when
        WinningStatistics winningStatistics = winningAnalyzer.calculateWinningStatistics();
        Map<WinningPrizes, Integer> result = winningStatistics.getWinningResults();
        //then
        assertThat(result.get(WinningPrizes.ZERO)).isEqualTo(1);
        assertThat(result.get(WinningPrizes.ONE)).isEqualTo(1);
        assertThat(result.get(WinningPrizes.TWO)).isEqualTo(1);
        assertThat(result.get(WinningPrizes.THREE)).isEqualTo(1);
        assertThat(result.get(WinningPrizes.FOUR)).isEqualTo(1);
        assertThat(result.get(WinningPrizes.FIVE)).isEqualTo(1);
        assertThat(result.get(WinningPrizes.FIVE_BONUS)).isEqualTo(1);
        assertThat(result.get(WinningPrizes.SIX)).isEqualTo(1);
    }

    @MethodSource("provideLottoList")
    @ParameterizedTest
    void 수익률을_반환한다(List<Set<Integer>> lottoList, Set<Integer> winningNumbers, int bonusNumber) {
        //given
        LottoResults lottoResults = LottoResults.fromIntegers(lottoList);
        WinningAnalyzer winningAnalyzer = new WinningAnalyzer(lottoResults, winningNumbers, bonusNumber);
        WinningStatistics winningStatistics = winningAnalyzer.calculateWinningStatistics();

        //when
        float roi = winningAnalyzer.getReturnOnInvestment(7000);
        float expectedResult = Arrays.stream(WinningPrizes.values()).mapToInt(prize -> prize.getPrizeMoney()).sum() / 7000;

        //then
        assertThat(areFloatsEqual(roi, expectedResult)).isTrue();
    }
    private static Stream<Arguments> provideLottoList() {
        return Stream.of(
            Arguments.of(
                Arrays.asList(
                    Arrays.asList(2, 4, 6, 7, 10, 12),
                    Arrays.asList(1, 4, 6, 7, 10, 12),
                    Arrays.asList(1, 2, 3, 4, 5, 6 ),
                    Arrays.asList(1, 4, 5, 6, 15, 17 ),// 5등(3개 일치)
                    Arrays.asList(1, 3, 15, 17, 18, 19 ), // 4등(4개 일치)
                    Arrays.asList(1, 3, 15, 17, 29, 35 ), // 3등(5개 일치)
                    Arrays.asList(1, 3, 15, 17, 29, 30 ), // 2등(5개 일치) & 보너스 일치
                    Arrays.asList(1, 3, 15, 17, 29, 31 )// 1등(6개 일치)
                ).stream().map(HashSet::new).collect(Collectors.toList()),
                new HashSet<>(Arrays.asList(1, 3, 15, 17, 29, 31)),
                30
            )
        );
    }

    private static boolean areFloatsEqual(float a, float b) {
        float epsilon = 1f;
        return Math.abs(a - b) <= epsilon;
    }
}
