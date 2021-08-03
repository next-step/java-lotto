package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class StringAdditionCalculatorTest {
    StringAdditionCalculator stringAdditionCalculator;

    @BeforeEach
    void setUp() {
        stringAdditionCalculator = new StringAdditionCalculator();
    }

    @ParameterizedTest
    @MethodSource
    void 쉼표_또는_콜론이_포함된_문자열을_입력받으면_쉼표_또는_콜론을_기준으로_문자열이_분리된다(String input, String[] expected) {
        String[] result = stringAdditionCalculator.splitWithCommaOrColon(input);
        assertThat(result).containsExactly(expected);
    }

    private static Stream<Arguments> 쉼표_또는_콜론이_포함된_문자열을_입력받으면_쉼표_또는_콜론을_기준으로_문자열이_분리된다() {
        return Stream.of(
                Arguments.of(
                        "",
                        new String[] {""}
                ),
                Arguments.of(
                        "1,2",
                        new String[] {"1", "2"}
                ),
                Arguments.of(
                        "1,2,3",
                        new String[] {"1", "2", "3"}
                ),
                Arguments.of(
                        "1,2:3",
                        new String[] {"1", "2", "3"}
                )
        );
    }

    @ParameterizedTest
    @MethodSource
    void 커스텀구분자가_포함된_문자열을_입력받으면_그_구분자를_기준으로_문자열이_분리된다(String input, String[] expected) {
        assertThat(stringAdditionCalculator.splitWithCustomDelimiter(input)).isEqualTo(expected);
    }

    private static Stream<Arguments> 커스텀구분자가_포함된_문자열을_입력받으면_그_구분자를_기준으로_문자열이_분리된다() {
        return Stream.of(
                Arguments.of(
                        "//;\n1;2;3",
                        new String[] {"1", "2", "3"}
                ),
                Arguments.of(
                        "//-\n4-5-6",
                        new String[] {"4", "5", "6"}
                ),
                Arguments.of(
                        "//~\n7~8~9",
                        new String[] {"7", "8", "9"}
                )
        );
    }

}
