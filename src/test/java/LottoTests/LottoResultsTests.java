package LottoTests;

import lotto.model.LottoResult;
import lotto.model.LottoResults;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 결과 테스트")
public class LottoResultsTests {

    private static List<LottoResults> lottoResultsList;

    static  {
        lottoResultsList = new ArrayList<>();
        lottoResultsList.add(LottoResults.create(Arrays.asList(LottoResult.SIX, LottoResult.THREE, LottoResult.FOUR, LottoResult.FIVE, LottoResult.TWO)));
        lottoResultsList.add(LottoResults.create(Arrays.asList(LottoResult.ONE, LottoResult.NONE, LottoResult.FOUR, LottoResult.ONE, LottoResult.TWO)));
        lottoResultsList.add(LottoResults.create(Arrays.asList(LottoResult.FIVE, LottoResult.NONE, LottoResult.ONE)));
        lottoResultsList.add(LottoResults.create(Arrays.asList(
                LottoResult.ONE, LottoResult.NONE, LottoResult.THREE, LottoResult.ONE, LottoResult.TWO,
                LottoResult.ONE, LottoResult.NONE, LottoResult.NONE, LottoResult.ONE, LottoResult.TWO)));
        lottoResultsList.add(LottoResults.create(Collections.singletonList(LottoResult.ONE)));

    }

    @DisplayName("로또 수익률 테스트")
    @ParameterizedTest
    @MethodSource("profitTestCases")
    public void profitTest(LottoResults lottoResults, Double expectedProfit) {
        assertThat(lottoResults.profit()).isEqualTo(expectedProfit);
    }

    @DisplayName("로또 결과 카운트 테스트")
    @ParameterizedTest
    @MethodSource("countTestCases")
    public void countTest(LottoResults lottoResults, LottoResult lottoResult, Long expectedCount) {
        assertThat(lottoResults.count(lottoResult)).isEqualTo(expectedCount);
    }

    private static Stream<Arguments> profitTestCases() {
        return Stream.of(
                Arguments.of(lottoResultsList.get(0), 400311.0),
                Arguments.of(lottoResultsList.get(1), 10.0),
                Arguments.of(lottoResultsList.get(2), 500.0),
                Arguments.of(lottoResultsList.get(3), 0.5),
                Arguments.of(lottoResultsList.get(4), 0.0));
    }

    private static Stream<Arguments> countTestCases() {
        return Stream.of(
                Arguments.of(lottoResultsList.get(0), LottoResult.FOUR, 1L),
                Arguments.of(lottoResultsList.get(1), LottoResult.ONE, 2L)
        );
    }
}
