package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    void 빈_문자열_또는_null_값을_입력할_경우_0을_반환한다() {
        assertThat(stringAdditionCalculator.splitAndSum("")).isEqualTo(0);
        assertThat(stringAdditionCalculator.splitAndSum(null)).isEqualTo(0);
    }

    @Test
    void 숫자하나인_문자열를_입력하면_정수형으로_반환한다() {
        assertThat(stringAdditionCalculator.splitAndSum("1")).isEqualTo(1);
    }

    @Test
    void 쉼표구분자가_포함된_숫자문자열를_입력하면_쉼표를_구분자로_하는_분리된_정수들을의_합을_반환한다() {
        assertThat(stringAdditionCalculator.splitAndSum("1,2")).isEqualTo(3);
    }

    @Test
    void 쉼표_또는_콜론_구분자가_포함된_숫자문자열를_입력하면_그_구분자로_분리된_정수들을의_합을_반환한다() {
        assertThat(stringAdditionCalculator.splitAndSum("1,2:3")).isEqualTo(6);
    }

    @Test
    void 커스텀_구분자가_포함된_숫자문자열를_입력하면_그_구분자로_분리된_정수들을의_합을_반환한다() {
        assertThat(stringAdditionCalculator.splitAndSum("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    void 음수가_포함된_숫자문자열를_입력하면_RuntimeException가_발생한다() {
        assertThatThrownBy(() -> stringAdditionCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void 숫자이외의_문자열_입력하면_RuntimeException가_발생한다() {
        assertThatThrownBy(() -> stringAdditionCalculator.splitAndSum("A,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}
