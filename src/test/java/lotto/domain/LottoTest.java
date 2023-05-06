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
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getNumbersTest() {
        assertThat(new Lotto(List.of(1, 2, 3, 4, 5, 6)).getNumbers())
            .containsExactly(1, 2, 3, 4, 5, 6);
    }

    static Stream<Arguments> initException() {
        return Stream.of(
            Arguments.of(List.of(1, 2, 3, 4, 5)),
            Arguments.of(List.of(1, 2, 3, 4, 5, 6, 7))
        );
    }

}