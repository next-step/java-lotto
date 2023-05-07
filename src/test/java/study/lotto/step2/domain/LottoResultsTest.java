package study.lotto.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static study.lotto.step2.domain.LottoResult.*;


class LottoResultsTest {
    @Test
    void winning_amount() {
        // given
        LottoResults lottoResults = new LottoResults(
                List.of(MATCH_THREE_NUMBERS, MATCH_FOUR_NUMBERS)
        );

        // when, then
        assertThat(lottoResults.winningAmount()).isEqualTo(55_000L);
    }

    @ParameterizedTest(name = "[{index}/4] {displayName}")
    @MethodSource("lottoResultsAndExpectedRateOfReturn")
    @DisplayName("로또 결과에 대한 수익률")
    void rate_of_return(LottoResults lottoResults, String expectedRateOfReturn) {
        assertThat(lottoResults.rateOfReturn()).isEqualTo(expectedRateOfReturn);
    }

    private static Stream<Arguments> lottoResultsAndExpectedRateOfReturn() {
        return Stream.of(
                Arguments.of(new LottoResults(List.of(NOT_WIN)), "0"),
                Arguments.of(new LottoResults(List.of(NOT_WIN, MATCH_THREE_NUMBERS)), "2.5"),
                Arguments.of(new LottoResults(List.of(NOT_WIN, MATCH_THREE_NUMBERS, MATCH_FIVE_NUMBERS_WITH_BONUS)), "1001.66"),
                Arguments.of(new LottoResults(List.of(NOT_WIN, MATCH_FIVE_NUMBERS, MATCH_SIX_NUMBERS)), "667166.66")
        );
    }

    @ParameterizedTest(name = "[{index}/6] {displayName}")
    @MethodSource("lottoResultAndExpectedCountOfLottoResult")
    @DisplayName("당첨 결과별 당첨 횟수 조회")
    void count_lotto_result(LottoResult lottoResult, int expectedCountOfLottoResult) {
        // given
        LottoResults lottoResults = new LottoResults(List.of(
                NOT_WIN, NOT_WIN, NOT_WIN, NOT_WIN, NOT_WIN,
                MATCH_THREE_NUMBERS, MATCH_THREE_NUMBERS, MATCH_THREE_NUMBERS, MATCH_THREE_NUMBERS,
                MATCH_FOUR_NUMBERS, MATCH_FOUR_NUMBERS, MATCH_FOUR_NUMBERS,
                MATCH_FIVE_NUMBERS, MATCH_FIVE_NUMBERS,
                MATCH_FIVE_NUMBERS_WITH_BONUS
        ));

        // when, then
        assertThat(lottoResults.countOf(lottoResult)).isEqualTo(expectedCountOfLottoResult);
    }

    private static Stream<Arguments> lottoResultAndExpectedCountOfLottoResult() {
        return Stream.of(
                Arguments.of(NOT_WIN, 5),
                Arguments.of(MATCH_THREE_NUMBERS, 4),
                Arguments.of(MATCH_FOUR_NUMBERS, 3),
                Arguments.of(MATCH_FIVE_NUMBERS, 2),
                Arguments.of(MATCH_FIVE_NUMBERS_WITH_BONUS, 1),
                Arguments.of(MATCH_SIX_NUMBERS, 0)
        );
    }
}