package lotto.model;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningLottoTest {

    @DisplayName("winningLotto와 lotto가 주어졌을 때 matchCount를 반환하는지 검증")
    @ParameterizedTest
    @MethodSource("winningLottoCountParameter")
    void matchCountTest(WinningLotto winningLotto, Lotto lotto, int expected) {
        assertThat(winningLotto.matchCount(lotto)).isEqualTo(expected);
    }

    private static Stream<Arguments> winningLottoCountParameter() {
        Lotto lotto = new Lotto(Arrays.asList(new Number(1),
                                              new Number(2),
                                              new Number(3),
                                              new Number(4),
                                              new Number(5),
                                              new Number(6)));
        return Stream.of(Arguments.of(new WinningLotto(lotto, new Number(7)), lotto, 6));
    }

    @DisplayName("winningLotto와 lotto, bonusNumber가 주어졌을 때 lotto가 bonusNumber를 가지고 있는지 검증")
    @ParameterizedTest
    @MethodSource("winningLottoBonusNumberParameter")
    void hasBonusNumberTest(WinningLotto winningLotto, Lotto lotto, boolean expected) {
        assertThat(winningLotto.hasBonusNumber(lotto)).isEqualTo(expected);
    }

    private static Stream<Arguments> winningLottoBonusNumberParameter() {
        Lotto lotto = new Lotto(Arrays.asList(new Number(1),
                                              new Number(2),
                                              new Number(3),
                                              new Number(4),
                                              new Number(5),
                                              new Number(6)));
        Lotto target = new Lotto(Arrays.asList(new Number(1),
                                               new Number(2),
                                               new Number(3),
                                               new Number(4),
                                               new Number(5),
                                               new Number(7)));
        return Stream.of(Arguments.of(new WinningLotto(lotto, new Number(7)), lotto, false),
                         Arguments.of(new WinningLotto(lotto, new Number(7)), target, true));
    }
}
