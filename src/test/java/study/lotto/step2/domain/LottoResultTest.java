package study.lotto.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class LottoResultTest {
    @Test
    @DisplayName("로또 당첨 번호 갯수가 1 이상 6 이하가 아닐 경우, IllegalArgumentException 예외 발생")
    void invalid_numbers_of_match() {
        // given
        int invalidNumbersOfMatch = 7;

        // when, then
        assertThatThrownBy(() -> LottoResult.of(invalidNumbersOfMatch))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 당첨 번호 갯수는 0 이상 6 이하의 정수: " + invalidNumbersOfMatch);
    }

    @ParameterizedTest(name = "[{index}/7] {displayName}")
    @MethodSource("numbersOfMatchAndLottoResult")
    @DisplayName("당첨 번호 갯수로 부터 LottoResult enum 반환")
    void lotto_result(int numbersOfMatch, LottoResult expectedLottoResult) {
        assertThat(LottoResult.of(numbersOfMatch)).isEqualTo(expectedLottoResult);
    }

    private static Stream<Arguments> numbersOfMatchAndLottoResult() {
        return Stream.of(
                Arguments.of(0, LottoResult.NOT_MATCH),
                Arguments.of(1, LottoResult.MATCH_ONE_NUMBER),
                Arguments.of(2, LottoResult.MATCH_TWO_NUMBERS),
                Arguments.of(3, LottoResult.MATCH_THREE_NUMBERS),
                Arguments.of(4, LottoResult.MATCH_FOUR_NUMBERS),
                Arguments.of(5, LottoResult.MATCH_FIVE_NUMBERS),
                Arguments.of(6, LottoResult.MATCH_SIX_NUMBERS)
        );
    }
}