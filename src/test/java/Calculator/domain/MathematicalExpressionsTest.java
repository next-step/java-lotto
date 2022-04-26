package Calculator.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MathematicalExpressionsTest {
    private static Stream<List<String>> invalidExpressions() {
        return Stream.of(
                List.of("1", "2"),
                List.of("1", "+"),
                List.of("+"),
                List.of("1", "2", "-"),
                List.of("1", "+", "2", "-"),
                Collections.emptyList(),
                null
        );
    }

    @Test
    void MathematicalExpressions은_올바른_수식으로_생성_가능하다() {
        assertThat(MathematicalExpressions.from(List.of("1", "+", "2")))
                .isInstanceOf(MathematicalExpressions.class);
    }

    @ParameterizedTest
    @MethodSource("invalidExpressions")
    void MathematicalExpressions은_올바르지_않은_수식으로_생성하면_예외를_발생시킨다(List<String> expressions) {
        assertThatThrownBy(() -> {
            MathematicalExpressions.from(expressions);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void result는_수식_결과를_반환한다() {
        assertAll(
                () -> assertEquals(MathematicalExpressions.from(List.of("1", "+", "2")).result(), 3),
                () -> assertEquals(MathematicalExpressions.from(List.of("1", "+", "2", "+", "2")).result(), 5),
                () -> assertEquals(MathematicalExpressions.from(List.of("2", "-", "2")).result(), 0),
                () -> assertEquals(MathematicalExpressions.from(List.of("1", "*", "2")).result(), 2),
                () -> assertEquals(MathematicalExpressions.from(List.of("2", "/", "2")).result(), 1),
                () -> assertEquals(MathematicalExpressions.from(List.of("1", "+", "2", "/", "3")).result(), 1)
        );
    }
}
