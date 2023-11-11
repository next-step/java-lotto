package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class OperatorTest {

    @Test
    @DisplayName("PLUS enum 클래스는 calculate() 메서드를 통해 두 수를 더한다.")
    void plus() {
        // given
        Operator operator = Operator.PLUS;
        // when
        int result = operator.calculate(1, 2);
        // then
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("MINUS enum 클래스는 calculate() 메서드를 통해 두 수를 뺀다.")
    void minus() {
        // given
        Operator operator = Operator.MINUS;
        // when
        int result1 = operator.calculate(1, 2);
        int result2 = operator.calculate(2, 1);
        // then
        assertThat(result1).isEqualTo(-1);
        assertThat(result2).isEqualTo(1);
    }

    @Test
    @DisplayName("MULTIPLE enum 클래스는 calculate() 메서드를 통해 두 수를 곱한다.")
    void multiple() {
        // given
        Operator operator = Operator.MULTIPLE;
        // when
        int result = operator.calculate(2, 4);
        // then
        assertThat(result).isEqualTo(8);
    }

    @Test
    @DisplayName("DIVIDE enum 클래스는 calculate() 메서드를 통해 두 수를 나누는데 소수점은 버리고 정수만 반환한다.")
    void divide() {
        // given
        Operator operator = Operator.DIVIDE;
        // when
        int result1 = operator.calculate(1, 2);
        int result2 = operator.calculate(4, 3);
        int result3 = operator.calculate(8, 4);
        int result4 = operator.calculate(8, -2);
        int result5 = operator.calculate(8, -3);
        int result6 = operator.calculate(-8, 2);
        int result7 = operator.calculate(-8, 3);
        // then
        assertThat(result1).isEqualTo(0);
        assertThat(result2).isEqualTo(1);
        assertThat(result3).isEqualTo(2);
        assertThat(result4).isEqualTo(-4);
        assertThat(result5).isEqualTo(-2);
        assertThat(result6).isEqualTo(-4);
        assertThat(result7).isEqualTo(-2);
    }

    @ParameterizedTest(name = "입력받은 문자를 통해 적절한 Operator 클래스를 반환해줍니다.")
    @CsvSource(value = {"PLUS, +", "MINUS, -", "MULTIPLE, *", "DIVIDE, /"})
    void findOperator(Operator operator, String sign) {
        // given
        // when
        Operator operatorEnum = Operator.findOperatorEnum(sign);
        // then
        assertThat(operatorEnum).isEqualTo(operator);
    }

    @Test
    @DisplayName("정의되지 않은 문자가 입력되면 RuntimeException 을 내보냅니다.")
    void invalidSign() {
        // given
        String invalid = "&";
        // when
        // then
        assertThatThrownBy(() -> Operator.findOperatorEnum(invalid))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("해당하는 연산자가 없습니다.");

    }
}