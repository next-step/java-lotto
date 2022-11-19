package calculator;

import calculator.domain.CalculatorDatas;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ExeceptionTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("빈값 입력 시 에러발생")
    void nullChk(String data){
        assertThatThrownBy(() -> new Calculator(data))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("데이터가 없습니다");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 . 2"})
    @DisplayName("올바른 기호가 아닐 시 에러발생")
    void signValueChk(String data){
        assertThatThrownBy(() -> new Calculator(data).startCalculate())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("올바른 기호가 아닙니다.");
    }
}