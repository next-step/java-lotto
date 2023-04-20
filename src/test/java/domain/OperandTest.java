package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class OperandTest {

    @Test
    @MethodSource("separatorAndConstantPair")
    @DisplayName("연산자 조회 테스트")
    void lookUp(String separator, Operand operand) {

        assertThat(Operand.lookUp(separator)).isEqualTo(operand);
    }


    static Stream<Arguments> separatorAndConstantPair() {
        return Stream.of(
                Arguments.arguments("+", Operand.ADDITION),
                Arguments.arguments("-", Operand.SUBTRACTION),
                Arguments.arguments("*", Operand.MULTIPLICATION),
                Arguments.arguments("/", Operand.DIVISION)
        );
    }

}