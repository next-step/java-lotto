package lotto.model;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningNumberTest {

    @DisplayName("winningNumber와 lotto가 주어졌을 때 matchCount를 반환하는지 검증")
    @ParameterizedTest
    @MethodSource("winningNumbersCountParameter")
    void matchCountTest(WinningNumber winningNumber, Lotto lotto, int expected) {
        assertThat(winningNumber.matchCount(lotto)).isEqualTo(expected);
    }

    private static Stream<Arguments> winningNumbersCountParameter() {
        Lotto lotto = new Lotto(Arrays.asList(new Number(1),
                                              new Number(2),
                                              new Number(3),
                                              new Number(4),
                                              new Number(5),
                                              new Number(6)));
        return Stream.of(Arguments.of(new WinningNumber(lotto, new Number(7)), lotto, 6));
    }

    @DisplayName("winningNumber와 lotto, bonusNumber가 주어졌을 때 lotto가 bonusNumber를 가지고 있는지 검증")
    @ParameterizedTest
    @MethodSource("winningNumbersBonusNumberParameter")
    void hasBonusNumberTest(WinningNumber winningNumber, Lotto lotto, boolean expected) {
        assertThat(winningNumber.hasBonusNumber(lotto)).isEqualTo(expected);
    }

    private static Stream<Arguments> winningNumbersBonusNumberParameter() {
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
        return Stream.of(Arguments.of(new WinningNumber(lotto, new Number(7)), lotto, false),
                         Arguments.of(new WinningNumber(lotto, new Number(7)), target, true));
    }
}
