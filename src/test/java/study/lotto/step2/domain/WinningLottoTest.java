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

class WinningLottoTest {
    @Test
    @DisplayName("당첨 번호가 6개가 아닐 경우, IllegalArgumentException 예외 발생")
    void invalid_winning_lotto_size_then_throw_IllegalArgumentException() {
        Integer[] invalidWinningLottoNumbers = {1, 2, 3, 4, 5, 6, 7};
        assertThatThrownBy(() -> new WinningLotto(invalidWinningLottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("당첨 번호 갯수는 6개입니다: " + invalidWinningLottoNumbers.length);
    }

    @ParameterizedTest(name = "[{index}/7] {displayName}")
    @MethodSource("lottoAndExpectedLottoResult")
    @DisplayName("단일 로또 결과 확인")
    void result_of_lotto(Lotto lotto, LottoResult expectedLottoResult) {
        // given
        WinningLotto winningLotto = new WinningLotto(1, 2, 3, 4, 5, 6);

        // when, then
        assertThat(winningLotto.lottoResultOf(lotto)).isEqualTo(expectedLottoResult);
    }

    @DisplayName("여러 로또 결과 확인")
    void result_of_lottos() {
        // given
        WinningLotto winningLotto = new WinningLotto(1, 2, 3, 4, 5, 6);

        Lotto notMatchLotto = new Lotto(11, 12, 13, 14, 15, 16);
        Lotto oneMatchLotto = new Lotto(1, 12, 13, 14, 15, 16);
        Lottos lottos = new Lottos(List.of(notMatchLotto, oneMatchLotto));

        // when
        LottoResults lottoResults = winningLotto.lottoResultsOf(lottos);

        // then
        LottoResults expectedLottoResults = new LottoResults(LottoResult.NOT_MATCH, LottoResult.MATCH_ONE_NUMBER);
        assertThat(lottoResults).isEqualTo(expectedLottoResults);
    }

    private static Stream<Arguments> lottoAndExpectedLottoResult() {
        return Stream.of(
                Arguments.of(new Lotto(1, 2, 3, 4, 5, 6), MATCH_SIX_NUMBERS),
                Arguments.of(new Lotto(1, 2, 3, 4, 5, 45), MATCH_FIVE_NUMBERS),
                Arguments.of(new Lotto(1, 2, 3, 4, 44, 45), MATCH_FOUR_NUMBERS),
                Arguments.of(new Lotto(1, 2, 3, 43, 44, 45), MATCH_THREE_NUMBERS),
                Arguments.of(new Lotto(1, 2, 42, 43, 44, 45), MATCH_TWO_NUMBERS),
                Arguments.of(new Lotto(1, 41, 42, 43, 44, 45), MATCH_ONE_NUMBER),
                Arguments.of(new Lotto(40, 41, 42, 43, 44, 45), NOT_MATCH)
        );
    }
}