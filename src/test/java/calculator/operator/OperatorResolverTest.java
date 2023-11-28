package calculator.operator;

import static calculator.operator.OperatorResolver.INPUT_OPERATOR_EXCEPTION;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class OperatorResolverTest {

    private OperatorResolver operatorResolver;

    @BeforeEach
    void setUp() {
        operatorResolver = new OperatorResolver(List.of(
                OperatorStrategy.PLUS,
                OperatorStrategy.MINUS,
                OperatorStrategy.MULTIPLY,
                OperatorStrategy.DIVIDE
        ));
    }

    @ParameterizedTest
    @DisplayName("연산자 저장소에서 연산자를 찾을 수 있다.")
    @MethodSource("parametersProvider")
    void find_operation(String given, Class<?> expected) {
        // when
        OperatorStrategy result = operatorResolver.findOperator(given);

        // then
        assertThat(result).isExactlyInstanceOf(expected);
    }

    private static Stream<Arguments> parametersProvider() {
        return Stream.of(
                arguments("+", OperatorStrategy.PLUS.getClass()),
                arguments("-", OperatorStrategy.MINUS.getClass()),
                arguments("*", OperatorStrategy.MULTIPLY.getClass()),
                arguments("/", OperatorStrategy.DIVIDE.getClass())
        );
    }

    @ParameterizedTest
    @DisplayName("연산자 저장소에서 연산자를 찾을 수 없으면 예외를 던진다.")
    @ValueSource(strings = {"^", "$", "%"})
    void find_operation_exception(String given) {
        // when // then
        assertThatThrownBy(() -> operatorResolver.findOperator(given))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(INPUT_OPERATOR_EXCEPTION);
    }
}