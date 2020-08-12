package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumbersTest {

    @Test
    void create() {
        List<Integer> inputList = Arrays.asList(4,4,4);
        Numbers numbers = Numbers.create(inputList);

        assertThat(numbers).isNotNull();
    }

    @DisplayName("hasNegativeNumber - 음수값 존재하는 경우 테스트")
    @ParameterizedTest
    @MethodSource("makeNumbersWithNegative")
    void hasNegativeNumber_test() {
        List<Integer> inputList = Arrays.asList(4,4,4);
        Numbers numbers = Numbers.create(inputList);

        Exception exception = assertThrows(RuntimeException.class, numbers::hasNegativeNumber);

        String expectedMessage = "음수값은 입력이 불가능합니다.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    private static Stream<Arguments> makeNumbersWithNegative() {
        return Stream.of(
                Arguments.of(Arrays.asList(3, -100, 24)),
                Arguments.of(Arrays.asList(-1))
        );
    }

}
