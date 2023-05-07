package step2.domain.entity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step2.domain.vo.LottoNumber;
import step2.domain.vo.LottoPrize;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoTest {

    @Test
    void 지난주_당첨_번호를_정상적으로_입력받는다() {
        final var lotto = LottoFactory.createAutoLotto(1, 2, 3, 4, 5, 6);
        final var lottoNumbers = lotto.getLottoNumbers();

        assertThat(lottoNumbers).hasSize(6);
    }

    @Test
    void 지난주_당첨번호가_6자리가_아닐경우_예외를_던진다() {
        assertThrows(
                IllegalArgumentException.class,
                () -> LottoFactory.createAutoLotto(1, 2, 3, 4, 5)
        );
    }

    @Test
    void 로또와_당첨번호를_비교하여_일치하는_번호의_갯수를_반환한다() {
        final var lotto = LottoFactory.createAutoLotto(1, 2, 3, 4, 5, 6);
        final var winnerNumbers = List.of(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(7), new LottoNumber(8)
        );

        final var actual = lotto.compareWinnerLottoNumbers(winnerNumbers);

        assertThat(actual).isEqualTo(4);
    }

    @ParameterizedTest(name = "로또번호: {0}, 보너스번호: {1}, 당첨번호: {2}, 결과: {3}")
    @MethodSource("provideTestCase")
    void 로또_당첨(Lotto lotto, WinnerLotto winner, LottoPrize expected) {
        final var actual = winner.prize(lotto);

        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> provideTestCase() {
        final var bonusNumber = new LottoNumber(45);
        final var winnerLotto = LottoFactory.createWinnerLotto(bonusNumber, 1, 2, 3, 4, 5, 6);

        return Stream.of(
                Arguments.arguments(LottoFactory.createAutoLotto(1, 2, 3, 4, 5, 6), winnerLotto, LottoPrize.FIRST),
                Arguments.arguments(LottoFactory.createAutoLotto(1, 2, 3, 4, 5, 45), winnerLotto, LottoPrize.SECOND_BONUS),
                Arguments.arguments(LottoFactory.createAutoLotto(1, 2, 3, 7, 8, 9), winnerLotto, LottoPrize.FOURTH),
                Arguments.arguments(LottoFactory.createAutoLotto(1, 2, 3, 4, 5, 7), winnerLotto, LottoPrize.SECOND),
                Arguments.arguments(LottoFactory.createAutoLotto(1, 2, 3, 4, 7, 8), winnerLotto, LottoPrize.THIRD)
        );
    }
}
