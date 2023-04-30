package study.lotto.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;


class LottoResultsTest {
    @Test
    void winning_amount() {
        // given
        LottoResults lottoResults = new LottoResults(
                List.of(LottoResult.MATCH_THREE_NUMBERS, LottoResult.MATCH_FOUR_NUMBERS)
        );

        // when, then
        assertThat(lottoResults.winningAmount()).isEqualTo(55_000L);
    }

    @ParameterizedTest(name = "[{index}/3] {displayName}")
    @MethodSource("lottoResultsAndExpectedRateOfReturn")
    @DisplayName("로또 결과에 대한 수익률")
    void rate_of_return(LottoResults lottoResults, String expectedRateOfReturn) {
        assertThat(lottoResults.rateOfReturn()).isEqualTo(expectedRateOfReturn);
    }

    private static Stream<Arguments> lottoResultsAndExpectedRateOfReturn() {
        return Stream.of(
                Arguments.of(new LottoResults(List.of(LottoResult.NOT_MATCH)), "0"),
                Arguments.of(new LottoResults(List.of(LottoResult.NOT_MATCH, LottoResult.MATCH_THREE_NUMBERS)), "2.5"),
                Arguments.of(new LottoResults(List.of(LottoResult.NOT_MATCH, LottoResult.MATCH_FIVE_NUMBERS, LottoResult.MATCH_SIX_NUMBERS)), "667166.67")
        );
    }
}