package step1.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OperatorsTest {

    @Test
    @DisplayName("생성 테스트")
    void list_arithmeticExpression_ctor_test() {
        assertThatNoException()
            .isThrownBy(() -> new Operators(List.of(new Operator('+'))));
    }

    @Test
    @DisplayName("연산자 가져오기 테스트")
    void get_arithmeticExpression_test() {
        Operators operators = new Operators(List.of(new Operator('+')));

        Operator operator = operators.operator();

        assertThat(operator).isEqualTo(new Operator('+'));
    }

    @Test
    @DisplayName("연산자를 추가로 가져오면 예외가 발생한다.")
    void over_get_operator_throw_exception_test() {
        //given
        Operators operators = new Operators(List.of(new Operator('+')));

        //when
        operators.operator();

        //then
        assertThatThrownBy(operators::operator)
            .isInstanceOf(IllegalStateException.class)
            .hasMessage("더 이상 연산자가 존재하지 않습니다.");

    }

}