package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CalculatorTest {

    @Test
    @DisplayName(value="사칙연산 검증")
    void 사칙연산_테스트(){
        Calculator cal = new Calculator(5);

        assertThat(cal.add(5)).isEqualTo(10);
        assertThat(cal.subtract(3)).isEqualTo(7);
        assertThat(cal.multiply(2)).isEqualTo(14);
        assertThat(cal.divide(7)).isEqualTo(2);
    }

    @Test
    @DisplayName(value="나눗셈 에러 체크")
    void 나눗셈_에러_체크(){
        assertThatThrownBy(()->{
            Calculator cal = new Calculator(5);
            cal.divide(3);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName(value="공식에 따른 답 체크")
    void 공식의_답_체크(){

        String formula = "2 + 3 * 4 / 2";

        assertThat(new Calculator(formula).calculateFormula()).isEqualTo(10);
    }
}