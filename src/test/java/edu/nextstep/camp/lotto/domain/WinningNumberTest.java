package edu.nextstep.camp.lotto.domain;

import java.util.Set;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static edu.nextstep.camp.lotto.domain.LottoTest.lotto;
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

    static Stream<Arguments> parseRank() {
        return Stream.of(
                Arguments.of(lotto(1, 2, 3, 4, 5, 6), Rank.FIRST),
                Arguments.of(lotto(1, 2, 3, 4, 5, 7), Rank.SECOND),
                Arguments.of(lotto(1, 2, 3, 43, 44, 45), Rank.FIFTH),
                Arguments.of(lotto(40, 41, 42, 43, 44, 45), Rank.NO_RANK)
        );
    }

    @ParameterizedTest(name = "rank with winning(1,2,3,4,5,6), bonus(7): {arguments}")
    @MethodSource("parseRank")
    public void rank(Lotto lotto, Rank expected) {
        final WinningNumber winningNumber = WinningNumber.of(Set.of(1, 2, 3, 4, 5, 6), 7);
        assertThat(winningNumber.rank(lotto)).isEqualTo(expected);
    }
}
