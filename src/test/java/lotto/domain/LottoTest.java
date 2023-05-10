package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class LottoTest {

    @ParameterizedTest
    @NullAndEmptySource
    @MethodSource("initException")
    void InitExceptionTest(List<Integer> numbers) {
        assertThatThrownBy(() -> new Lotto(numbers))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("In Lotto entered not supported argument");
    }

    @ParameterizedTest
    @MethodSource("scoreHitArgs")
    void scoreHitTest(Lotto winningNumber, Integer expected) {
        assertThat(new Lotto(List.of(1, 2, 3, 4, 5, 6)).scoreHit(winningNumber)).isEqualTo(
            expected);
    }

    @Test
    void duplicateExceptionTest() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 1, 2, 3, 4, 5)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("In Lotto do not allow duplicate number");
    }

    static Stream<Arguments> initException() {
        return Stream.of(
            Arguments.of(List.of(1, 2, 3, 4, 5)),
            Arguments.of(List.of(1, 2, 3, 4, 5, 6, 7))
        );
    }

    static Stream<Arguments> scoreHitArgs() {
        return Stream.of(
            Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 6),
            Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 45)), 5),
            Arguments.of(new Lotto(List.of(1, 2, 3, 4, 44, 45)), 4),
            Arguments.of(new Lotto(List.of(1, 2, 3, 43, 44, 45)), 3),
            Arguments.of(new Lotto(List.of(1, 2, 42, 43, 44, 45)), 2),
            Arguments.of(new Lotto(List.of(1, 41, 42, 43, 44, 45)), 1),
            Arguments.of(new Lotto(List.of(40, 41, 42, 43, 44, 45)), 0)
        );
    }

}