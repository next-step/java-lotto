package calculator.domain.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("StringCalculator 클래스 테스트")
public class StringCalculatorTest {

    @DisplayName("문자열 List를 입력받아 Number List를 생성할 수 있다.")
    @Test
    void number() {
        String[] texts = {"1", "2", "3"};

        StringCalculator stringCalculator = new StringCalculator(texts);

        assertThat(stringCalculator).isNotNull();
        assertThat(stringCalculator.getNumbers().get(0).getNumber()).isEqualTo(1);
    }

    @DisplayName("숫자가 아닌 값을 전달하는 경우 RuntiemException 예외를 throw 할 수 있다.")
    @Test
    void NonNumericValues() {
        String[] texts = {"1", "-", "3"};
        assertThatThrownBy(() -> new StringCalculator(texts)).isInstanceOf(NonNumericValuesException.class);
    }

    @DisplayName("문자열 숫자의 합을 구할 수 있다.")
    @ParameterizedTest
    @MethodSource("numbers")
    void sum(String[] input, int expected) {
        Calculator calculator = new StringCalculator(input);

        int actual = calculator.sum();

        assertThat(actual).isEqualTo(expected);
    }

    public static Stream<Arguments> numbers() {
        return Stream.of(
                Arguments.of(new String[]{"1", "2", "3"}, 6),
                Arguments.of(new String[]{"1", "2", "3", "4"}, 10),
                Arguments.of(new String[]{"1", "2", "3", "4", "5"}, 15)
        );
    }
}
