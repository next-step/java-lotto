package camp.nextstep.edu.lotto;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class LottoTest {

    @Test
    @DisplayName("중복없는 1~45 사이의 6개 숫자가 들어오면 잘 만들어진다")
    void number_count_is_6() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        assertDoesNotThrow(() -> new Lotto(numbers));
    }

    @ParameterizedTest
    @MethodSource("numbersNotSixQuantity")
    @DisplayName("숫자의 개수가 6개가 아니라면 예외가 발생한다")
    void number_count_is_6(List<Integer> numbers) {
        assertThrows(
            IllegalArgumentException.class,
            () -> new Lotto(numbers)
        );
    }

    private static Stream<Arguments> numbersNotSixQuantity() {
        return Stream.of(
            Arguments.of(List.of(1, 2, 3, 4, 5)),
            Arguments.of(List.of(1, 2, 3, 4, 5, 6, 7))
        );
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("null이나 빈 List가 들어오면 예외가 발생한다")
    void numbers_not_null(List<Integer> numbers) {
        assertThrows(
            IllegalArgumentException.class,
            () -> new Lotto(numbers)
        );
    }

    @ParameterizedTest
    @MethodSource("numbersNotBetween1And45")
    @DisplayName("숫자가 1~45 사이가 아니라면 예외가 발생한다")
    void number_is_between_1_45(List<Integer> numbers) {
        assertThrows(
            IllegalArgumentException.class,
            () -> new Lotto(numbers)
        );
    }

    private static Stream<Arguments> numbersNotBetween1And45() {
        return Stream.of(
            Arguments.of(List.of(1, 2, 3, 4, 5, 0)),
            Arguments.of(List.of(1, 2, 3, 4, 5, 46))
        );
    }

    @Test
    @DisplayName("중복되는 숫자가 있다면 예외가 발생한다")
    void numbers_are_duplicated() {
        List<Integer> numbers = List.of(1, 1, 2, 3, 4, 5);
        assertThrows(
            IllegalArgumentException.class,
            () -> new Lotto(numbers)
        );
    }
}
