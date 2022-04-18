package me.devyonghee.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("연산 종류")
class OperationTest {

    @ParameterizedTest(name = "[{index}] {0} 의 기호로 연산을 가져오면 {1}")
    @DisplayName("연산 기호로 연산 종류 가져오기")
    @CsvSource({"+,PLUS", "-,MINUS", "*,MULTIPLY", "/,DIVIDE"})
    void of(String symbol, Operation expected) {
        assertThat(Operation.of(symbol)).isEqualTo(expected);
    }

    @Test
    @DisplayName("존재하지 않는 기호라면 IllegalArgumentException")
    void of_notSupported_thrownIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> Operation.of(""));
    }

    @Test
    @DisplayName("연산 기호 판단하기")
    void is() {
        assertThat(Operation.PLUS.isPlus()).isTrue();
        assertThat(Operation.MINUS.isMinus()).isTrue();
        assertThat(Operation.DIVIDE.isDivide()).isTrue();
        assertThat(Operation.MULTIPLY.isMultiply()).isTrue();
    }
}
