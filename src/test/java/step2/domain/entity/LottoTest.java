package step2.domain.entity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step2.domain.vo.LottoNumber;
import step2.domain.vo.LottoPrize;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoTest {

    @Test
    void 지난주_당첨_번호를_정상적으로_입력받는다() {
        final var lotto = Lotto.winner("1, 2, 3, 4, 5, 6");
        final var lottoNumbers = lotto.getLottoNumbers();

        assertThat(lottoNumbers).hasSize(6);
    }

    @Test
    void 지난주_당첨번호가_6자리가_아닐경우_예외를_던진다() {
        assertThrows(
                IllegalArgumentException.class,
                () -> Lotto.winner("1, 2, 3, 4, 5")
        );
    }

    @ParameterizedTest(name = "로또번호: {0}, 보너스번호: {1}, 당첨번호: {2}, 결과: {3}")
    @MethodSource("provideTestCase")
    void 로또_당첨(Lotto lotto, LottoNumber bonus, Lotto winner, LottoPrize expected) {
        final var actual = winner.prize(lotto, bonus);

        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> provideTestCase() {
        return Stream.of(
                Arguments.arguments(new Lotto(1, 2, 3, 4, 5, 6), new LottoNumber(45), new Lotto(1, 2, 3, 4, 5, 6), LottoPrize.FIRST),
                Arguments.arguments(new Lotto(1, 2, 3, 4, 5, 45), new LottoNumber(45), new Lotto(1, 2, 3, 4, 5, 6), LottoPrize.SECOND_BONUS),
                Arguments.arguments(new Lotto(1, 2, 3, 4, 5, 7), new LottoNumber(45), new Lotto(1, 2, 3, 4, 5, 6), LottoPrize.SECOND),
                Arguments.arguments(new Lotto(1, 2, 3, 4, 7, 8), new LottoNumber(45), new Lotto(1, 2, 3, 4, 5, 6), LottoPrize.THIRD),
                Arguments.arguments(new Lotto(1, 2, 3, 7, 8, 9), new LottoNumber(45), new Lotto(1, 2, 3, 4, 5, 6), LottoPrize.FOURTH)
        );
    }
}
