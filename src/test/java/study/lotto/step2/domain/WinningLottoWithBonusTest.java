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

class WinningLottoWithBonusTest {
    @ParameterizedTest(name = "[{index}/6] {displayName}")
    @MethodSource("lottoAndExpectedLottoResult")
    @DisplayName("단일 로또 결과 확인")
    void result_of_lotto(Lotto lotto, LottoResult expectedLottoResult) {
        // given
        WinningLotto winningLotto = new WinningLotto(1, 2, 3, 4, 5, 6);
        BonusNumber bonusNumber = new BonusNumber(winningLotto, LottoNumber.of(7));
        WinningLottoWithBonus winningLottoWithBonus = new WinningLottoWithBonus(winningLotto, bonusNumber);

        // when, then
        assertThat(winningLottoWithBonus.resultOf(lotto)).isEqualTo(expectedLottoResult);
    }

    @Test
    @DisplayName("여러 로또 결과 확인")
    void result_of_lottos() {
        // given
        WinningLotto winningLotto = new WinningLotto(1, 2, 3, 4, 5, 6);
        BonusNumber bonusNumber = new BonusNumber(winningLotto, LottoNumber.of(7));
        WinningLottoWithBonus winningLottoWithBonus = new WinningLottoWithBonus(winningLotto, bonusNumber);

        Lotto matchFiveNumbersWithBonusLotto = new Lotto(1, 2, 3, 4, 5, 7);
        Lotto matchThreeNumbersLotto = new Lotto(1, 2, 3, 11, 12, 13);
        Lottos lottos = new Lottos(List.of(matchFiveNumbersWithBonusLotto, matchThreeNumbersLotto));

        // when
        LottoResults lottoResults = winningLottoWithBonus.resultsOf(lottos);

        // then
        LottoResults expectedLottoResults = new LottoResults(MATCH_FIVE_NUMBERS_WITH_BONUS, MATCH_THREE_NUMBERS);
        assertThat(lottoResults).isEqualTo(expectedLottoResults);
    }

    private static Stream<Arguments> lottoAndExpectedLottoResult() {
        return Stream.of(
                Arguments.of(new Lotto(1, 2, 3, 4, 5, 6), MATCH_SIX_NUMBERS),
                Arguments.of(new Lotto(1, 2, 3, 4, 5, 7), MATCH_FIVE_NUMBERS_WITH_BONUS),
                Arguments.of(new Lotto(1, 2, 3, 4, 5, 45), MATCH_FIVE_NUMBERS),
                Arguments.of(new Lotto(1, 2, 3, 4, 44, 45), MATCH_FOUR_NUMBERS),
                Arguments.of(new Lotto(1, 2, 3, 43, 44, 45), MATCH_THREE_NUMBERS),
                Arguments.of(new Lotto(40, 41, 42, 43, 44, 45), NOT_WIN)
        );
    }
}