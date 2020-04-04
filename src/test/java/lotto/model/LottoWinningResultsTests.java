package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 결과 다수 테스트")
public class LottoWinningResultsTests {

    private static List<LottoWinningResults> lottoWinningResultsList;

    static {
        lottoWinningResultsList = new ArrayList<>();
        lottoWinningResultsList.add(LottoWinningResults.create(Arrays.asList(LottoWinningResult.SIX, LottoWinningResult.THREE, LottoWinningResult.FOUR, LottoWinningResult.FIVE, LottoWinningResult.TWO)));
        lottoWinningResultsList.add(LottoWinningResults.create(Arrays.asList(LottoWinningResult.ONE, LottoWinningResult.NONE, LottoWinningResult.FOUR, LottoWinningResult.ONE, LottoWinningResult.TWO)));
        lottoWinningResultsList.add(LottoWinningResults.create(Arrays.asList(LottoWinningResult.FIVE, LottoWinningResult.NONE, LottoWinningResult.ONE)));
        lottoWinningResultsList.add(LottoWinningResults.create(Arrays.asList(
                LottoWinningResult.ONE, LottoWinningResult.NONE, LottoWinningResult.THREE, LottoWinningResult.ONE, LottoWinningResult.TWO,
                LottoWinningResult.ONE, LottoWinningResult.NONE, LottoWinningResult.NONE, LottoWinningResult.ONE, LottoWinningResult.TWO)));
        lottoWinningResultsList.add(LottoWinningResults.create(Collections.singletonList(LottoWinningResult.ONE)));

    }

    @DisplayName("로또 수익률 테스트")
    @ParameterizedTest
    @MethodSource("profitTestCases")
    public void profitTest(LottoWinningResults lottoWinningResults, BigDecimal expectedProfit) {
        assertThat(lottoWinningResults.profit()).isEqualTo(expectedProfit);
    }

    @DisplayName("로또 결과 카운트 테스트")
    @ParameterizedTest
    @MethodSource("countTestCases")
    public void countTest(LottoWinningResults lottoWinningResults, LottoWinningResult lottoWinningResult, long expectedCount) {
        assertThat(lottoWinningResults.count(lottoWinningResult)).isEqualTo(expectedCount);
    }

    private static Stream<Arguments> profitTestCases() {
        return Stream.of(
                Arguments.of(lottoWinningResultsList.get(0), BigDecimal.valueOf(400311.0)),
                Arguments.of(lottoWinningResultsList.get(1), BigDecimal.valueOf(10.0)),
                Arguments.of(lottoWinningResultsList.get(2), BigDecimal.valueOf(500.0)),
                Arguments.of(lottoWinningResultsList.get(3), BigDecimal.valueOf(0.5)),
                Arguments.of(lottoWinningResultsList.get(4), BigDecimal.valueOf(0.0)));
    }

    private static Stream<Arguments> countTestCases() {
        return Stream.of(
                Arguments.of(lottoWinningResultsList.get(0), LottoWinningResult.FOUR, 1L),
                Arguments.of(lottoWinningResultsList.get(1), LottoWinningResult.ONE, 2L)
        );
    }
}
