package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class OperatorsTest {

    @Test
    @DisplayName("적절한 문자가 들어오면 이에 맞는 Operator 를 리스트에 추가해줍니다.")
    void addOperator() {
        // given
        String inputText = "+";
        Operators operators = new Operators();
        // when
        operators.addOperator(inputText);
        // then
        assertThat(operators).isEqualTo(new Operators(List.of(Operator.PLUS)));
    }

    @Test
    @DisplayName("내부에 아무런 Operator가 없다면 false를 반환합니다.")
    void hasOperator() {
        // given
        Operators operators1 = new Operators();
        Operators operators2 = new Operators();
        operators2.addOperator("+");
        // when
        boolean result1 = operators1.hasElement();
        boolean result2 = operators2.hasElement();
        // then
        assertThat(result1).isFalse();
        assertThat(result2).isTrue();
    }

}