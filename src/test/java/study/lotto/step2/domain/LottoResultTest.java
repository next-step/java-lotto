package study.lotto.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class LottoResultTest {
    @ParameterizedTest(name = "[{index}/8] {displayName}")
    @MethodSource("numbersOfMatchAndIsBonusMatchAndLottoResult")
    @DisplayName("당첨 번호 갯수와 보너스 번호 일치 여부를 확인하여 LottoResult enum 반환")
    void lotto_result(int numbersOfMatch, boolean isBonusMatch, LottoResult expectedLottoResult) {
        assertThat(LottoResult.of(numbersOfMatch, isBonusMatch)).isEqualTo(expectedLottoResult);
    }

    @Test
    @DisplayName("매칭되는 결과가 없을 경우, `NOT_WIN` 반환")
    void not_win() {
        // given
        int numberOfMatch = 2;
        boolean isBonusMatch = true;

        // then
        LottoResult lottoResult = LottoResult.of(numberOfMatch, isBonusMatch);

        // then
        assertThat(lottoResult).isEqualTo(LottoResult.NOT_WIN);
    }

    private static Stream<Arguments> numbersOfMatchAndIsBonusMatchAndLottoResult() {
        return Stream.of(
                Arguments.of(0, false, LottoResult.NOT_WIN),
                Arguments.of(3, false, LottoResult.MATCH_THREE_NUMBERS),
                Arguments.of(3, true, LottoResult.MATCH_THREE_NUMBERS),
                Arguments.of(4, false, LottoResult.MATCH_FOUR_NUMBERS),
                Arguments.of(4, true, LottoResult.MATCH_FOUR_NUMBERS),
                Arguments.of(5, false, LottoResult.MATCH_FIVE_NUMBERS),
                Arguments.of(5, true, LottoResult.MATCH_FIVE_NUMBERS_WITH_BONUS),
                Arguments.of(6, false, LottoResult.MATCH_SIX_NUMBERS)
        );
    }
}