package lotto.step1;

import lotto.step1.model.Expression;
import lotto.step1.model.NonNegativeInteger;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ExpressionTest {

    @ParameterizedTest(name = "illegalArgumentExceptionTest")
    @ValueSource(strings = {"//\n1:2:3", "1d,2,3", "//;\n1;2;a;3"})
    public void illegalArgumentExceptionTest(String input) {
        assertThatThrownBy(() -> new Expression(input).integers())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "illegalArgumentExceptionTest")
    @MethodSource("stringArrayProvider")
    public void splitTest(String expression, String[] array) {
        assertThat(new Expression(expression).integers()).isEqualTo(array);
    }


    static Stream<Arguments> stringArrayProvider() {
        return Stream.of(
                Arguments.of("5:7:34",(Object) new String[]{"5", "7", "34"}),
                Arguments.of("25:11:2:38",(Object) new String[]{"25", "11", "2", "38"}),
                Arguments.of("//f\n13f63f32f21",(Object) new String[]{"13", "63", "32", "21"})
        );
    }

}
