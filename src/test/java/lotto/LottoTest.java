package lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @ParameterizedTest
    @MethodSource("getWinningNumber")
    void checkLotto(List<Integer> winningNumber, int expected) {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        int matchNumber = lotto.getMatchCount(winningNumber);

        assertThat(matchNumber).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("getLottoNumber")
    void checkLottoBonus(List<Integer> lottoNums, int bonus, boolean expected) {
        Lotto lotto = new Lotto(lottoNums);
        boolean hasBonus = lotto.hasNumber(bonus);

        assertThat(hasBonus).isEqualTo(expected);
    }

    private static Stream<Arguments> getWinningNumber() {
        List<Integer> all = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> none = List.of(11, 12, 13, 14, 15, 16);
        List<Integer> half = List.of(1, 2, 3, 14, 15, 16);
        return Stream.of(
                Arguments.of(all, 6),
                Arguments.of(none, 0),
                Arguments.of(half, 3)
        );
    }

    private static Stream<Arguments> getLottoNumber() {
        List<Integer> has = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> not = List.of(11, 12, 13, 14, 15, 16);
        int bonus = 1;
        return Stream.of(
                Arguments.of(has, bonus, true),
                Arguments.of(not, bonus, false)
        );
    }
}
