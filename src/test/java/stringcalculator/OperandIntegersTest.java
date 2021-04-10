package stringcalculator;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class OperandIntegersTest {

    static Stream<Arguments> parameters() {
        return Stream.of(
                arguments(new String[]{"0", "1"}, Lists.list(OperandInteger.of("0"), OperandInteger.of("1"))),
                arguments(new String[]{"1", "2"}, Lists.list(OperandInteger.of("1"), OperandInteger.of("2")))
        );
    }

    @ParameterizedTest
    @DisplayName("생성자 테스트")
    @MethodSource("parameters")
    void create(String[] inputNumbers, List<OperandInteger> operandIntegers) {
        assertThat(new OperandIntegers(inputNumbers)).isEqualTo(new OperandIntegers(operandIntegers));
    }

    @Test
    @DisplayName("생성자 예외 테스트")
    void validate() {
        assertThatThrownBy(() -> new OperandIntegers(new String[]{"-1", "0"})).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("덧셈 테스트")
    void sumTest() {
        OperandIntegers expected = new OperandIntegers(new String[]{"0", "1"});
        assertThat(expected.sum()).isEqualTo(1);
    }
}
