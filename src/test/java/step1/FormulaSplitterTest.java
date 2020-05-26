package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class FormulaSplitterTest {

    @DisplayName("콤마(,)또는 콜론(:) 구분자로 문자열을 분할하여 숫자 배열을 반환한다")
    @MethodSource("provideStringsForDelimiter")
    @ParameterizedTest
    void split_NumberWithDelimiter_Tokens(String formula, Operand expectedFirst, Operand expectedSecond) {
        List<Operand> operands = FormulaSplitter.split(Formula.valueOf(formula));

        assertThat(operands).hasSize(2);
        assertThat(operands.get(0)).isEqualTo(expectedFirst);
        assertThat(operands.get(1)).isEqualTo(expectedSecond);
    }

    private static Stream<Arguments> provideStringsForDelimiter() {
        return Stream.of(
                Arguments.of("1,2", Operand.valueOf("1"), Operand.valueOf("2")),
                Arguments.of("4,5", Operand.valueOf("4"), Operand.valueOf("5")),
                Arguments.of("3,1", Operand.valueOf("3"), Operand.valueOf("1")),
                Arguments.of("5:5", Operand.valueOf("5"), Operand.valueOf("5")),
                Arguments.of("2:9", Operand.valueOf("2"), Operand.valueOf("9"))
        );
    }

    @DisplayName("// 과 \n 사이에 있는 커스텀 구분자로 문자열을 분할하여 숫자 배열을 반환한다")
    @MethodSource("provideStringsForCustomDelimiter")
    @ParameterizedTest
    void split_NumberWithCustomDelimiter_Tokens(String formula, Operand expectedFirst, Operand expectedSecond) {
        List<Operand> operands = FormulaSplitter.split(Formula.valueOf(formula));

        assertThat(operands).hasSize(2);
        assertThat(operands.get(0)).isEqualTo(expectedFirst);
        assertThat(operands.get(1)).isEqualTo(expectedSecond);
    }

    private static Stream<Arguments> provideStringsForCustomDelimiter() {
        return Stream.of(
                Arguments.of("//*\n1*2", Operand.valueOf("1"), Operand.valueOf("2")),
                Arguments.of("//;\n4;5", Operand.valueOf("4"), Operand.valueOf("5")),
                Arguments.of("//+\n3+1", Operand.valueOf("3"), Operand.valueOf("1"))
        );
    }

    @DisplayName("올바르지 않은 커스텀 구분자를 사용하면 예외를 반환한다")
    @MethodSource("provideStringsForInvalidDelimiter")
    @ParameterizedTest
    void split_NumberWithInvalidDelimiter_ExceptionThrown(String formula) {
        assertThatThrownBy(() -> FormulaSplitter.split(Formula.valueOf(formula)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> provideStringsForInvalidDelimiter() {
        return Stream.of(
                Arguments.of("//*//*\n3*1"),
                Arguments.of("//*//*/*\n3*1")
        );
    }
}
