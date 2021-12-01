package edu.nextstep.camp.lotto.domain;

import java.util.Set;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class WinningNumberTest {
    static Stream<Arguments> parseWinningNumber() {
        return Stream.of(
                Arguments.of(Set.of(1, 2, 3, 4, 5, 6), 7)
        );
    }

    @ParameterizedTest(name = "create: {arguments}")
    @MethodSource("parseWinningNumber")
    public void create(Set<Integer> winningNumber, int bonusNumber) {
        assertThat(WinningNumber.of(winningNumber, bonusNumber)).isEqualTo(WinningNumber.of(winningNumber, bonusNumber));
    }


    static Stream<Arguments> parseCreateFailed() {
        return Stream.of(
                Arguments.of(Set.of(1, 2, 3, 4, 5, 6), 6, "winning number and bonus number must be exclusive"),
                Arguments.of(null, 6, "cannot be null")
        );
    }

    @ParameterizedTest(name = "create failed: {0},{1} -> {2}")
    @MethodSource("parseCreateFailed")
    public void createFailed(Set<Integer> winningNumber, int bonusNumber, String expectedMessage) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> WinningNumber.of(winningNumber, bonusNumber))
                .withMessageContaining(expectedMessage);
    }


    @ParameterizedTest(name = "numbers and bonus: {arguments}")
    @MethodSource("parseWinningNumber")
    public void numbersAndBonus(Set<Integer> winningNumber, int bonusNumber) {
        assertThat(WinningNumber.of(winningNumber, bonusNumber).numbers()).isEqualTo(Lotto.fromIntegers(winningNumber));
        assertThat(WinningNumber.of(winningNumber, bonusNumber).bonus()).isEqualTo(LottoNumber.of(bonusNumber));
    }
}
