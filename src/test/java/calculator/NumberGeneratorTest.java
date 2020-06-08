package calculator;

import calculator.domain.Number;
import calculator.domain.NumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberGeneratorTest {

    @ParameterizedTest
    @DisplayName("유효한 입력 값을 받을 경우 Number의 리스트가 만들어지는 지 테스트")
    @MethodSource("provideValidStrings")
    void isNumbersWhenInputIsValid(String input, List<Number> expected) {
        List<Number> actual = NumberGenerator.generate(input);

        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> provideValidStrings() {
        return Stream.of(
                Arguments.of("23", Arrays.asList(new Number("23"))),
                Arguments.of("//;\n1;2;3", Arrays.asList(new Number("1"), new Number("2"), new Number("3"))),
                Arguments.of("5:2,3", Arrays.asList(new Number("5"), new Number("2"), new Number("3")))
        );
    }
}
