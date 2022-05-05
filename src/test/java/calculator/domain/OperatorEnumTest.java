package calculator.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OperatorEnumTest {
    private static Stream<String> invalidSigns() {
        return Stream.of("a", "1", " ", "", null);
    }

    @ParameterizedTest
    @ValueSource(strings = {"+", "-", "*", "/"})
    void OperatorEnum은_연산자_문자로_찾을_수_있다(String sign) {
        assertThat(OperatorEnum.get(sign))
                .isInstanceOf(OperatorEnum.class);
    }

    @ParameterizedTest
    @MethodSource("invalidSigns")
    void OperatorEnum는_숫자가_아닌_문자열로_조회시_예외를_발생시킨다(String sign) {
        assertThatThrownBy(() -> {
            OperatorEnum.get(sign);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
