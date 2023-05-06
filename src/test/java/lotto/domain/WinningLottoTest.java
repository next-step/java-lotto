package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WinningLottoTest {
    @ParameterizedTest(name = "{0} 로또에 대한 결과는 {1}이다.")
    @MethodSource("getInputFor_로또가_당첨되었는지_알_수_있다")
    void 로또가_당첨되었는지_알_수_있다(Lotto input, LottoPrize prize) {
        Lotto lotto = Lotto.from("1, 2, 3, 4, 5, 6");
        LottoNumber bonusNumber = new LottoNumber(7);
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);
        assertThat(winningLotto.getMatchResult(input)).isEqualTo(prize);
    }

    private static Stream<Arguments> getInputFor_로또가_당첨되었는지_알_수_있다() {
        return Stream.of(
                Arguments.arguments(Lotto.from("1, 2, 3, 4, 5, 6"), LottoPrize.FIRST),
                Arguments.arguments(Lotto.from("1, 2, 3, 4, 5, 7"), LottoPrize.SECOND),
                Arguments.arguments(Lotto.from("1, 2, 3, 4, 5, 8"), LottoPrize.THIRD),
                Arguments.arguments(Lotto.from("1, 2, 3, 4, 7, 8"), LottoPrize.FOURTH),
                Arguments.arguments(Lotto.from("1, 2, 3, 7, 8, 9"), LottoPrize.FIFTH),
                Arguments.arguments(Lotto.from("6, 7, 8, 9, 10, 11"), LottoPrize.NONE)
        );
    }
}
