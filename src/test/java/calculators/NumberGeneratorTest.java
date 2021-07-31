package calculators;

import calculators.vo.Number;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NumberGeneratorTest {

    private NumberGenerator numberGenerator;

    @BeforeEach
    void setUp() {
        numberGenerator = new NumberGenerator();
    }

    @Test
    @DisplayName("기본 구분자 입력받아 Numbers 반환하기")
    void basicSeparator() {
        final String input = "1,2:3";
        List<Number> numbers = numberGenerator.getNumbers(input);
        List<Number> result = Arrays.asList(Number.from("1"), Number.from("2"), Number.from("3"));
        assertEquals(numbers, result);
    }

    @Test
    @DisplayName("커스텀 구분자 입력받아 Numbers 반환하기")
    void customSeparator() {
        final String input = "//;\n1;2;3";
        List<Number> numbers = numberGenerator.getNumbers(input);
        List<Number> result = Arrays.asList(Number.from("1"), Number.from("2"), Number.from("3"));
        assertEquals(numbers, result);
    }

    @Test
    @DisplayName("음수가 전달되는 경우 RuntimeException 발생")
    void negative() {
        assertThrows(RuntimeException.class, () -> {
            final String input = "//;\n-1;2;3";
            numberGenerator.getNumbers(input);
        });
    }

    @Test
    @DisplayName("문자 값이 전달되는 경우 RuntimeException 발생")
    void text() {
        assertThrows(RuntimeException.class, () -> {
            final String input = "//;\na;2;3";
            numberGenerator.getNumbers(input);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @NullAndEmptySource
    @DisplayName("null, empty ,공백일 경우 RuntimeException 발생")
    void blank(final String input) {
        assertThrows(RuntimeException.class, () -> {
            numberGenerator.getNumbers(input);
        });
    }
}