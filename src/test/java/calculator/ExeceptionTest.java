package calculator;

import calculator.domain.CalculatorDatas;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ExeceptionTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("빈값 입력 시 에러발생")
    void nullChk(String data){
        assertThatThrownBy(() -> CalculatorDatas.numbersMake(data))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("데이터가 없습니다");
    }
}
