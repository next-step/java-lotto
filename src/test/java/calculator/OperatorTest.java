package calculator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class OperatorTest {
    @Test
    @DisplayName("연산자 null 체크")
    void 연산자_null_체크() {
        String oper = null;

        assertThatThrownBy(() -> {
            new Operator(oper);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("연산자는 null이 될 수 없습니다");

    }

    @Test
    @DisplayName("잘못된 사칙연산 기호 체크")
    void 연산자_잘못된_사칙연산_기호_체크() {
        String oper = "%";

        assertThatThrownBy(() -> new Operator(oper))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("잘못된 사칙연산 기호입니다");
    }

    @ParameterizedTest
    @DisplayName("연산자 생성자 성공 테스트")
    @CsvSource(value = {"+,+","-,-","*,*","/,/"}, delimiter = ',')
    void 연산자_생성자_성공_테스트(String input, String expected) {
        Operator operator = new Operator(input);

        assertThat(operator).isEqualTo(new Operator(expected));
    }

}