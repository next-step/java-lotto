package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ExpressionTest {

    @DisplayName("연산기호에 맞는 Expression을 반환합니다.")
    @Test
    void anyOperationMarkMustReturnAppropriateClass() {
        assertThat(Expression.of("+")).isEqualTo(Expression.PLUS);
        assertThat(Expression.of("-")).isEqualTo(Expression.MINUS);
        assertThat(Expression.of("*")).isEqualTo(Expression.MULTIPLICATION);
        assertThat(Expression.of("/")).isEqualTo(Expression.DIVIDE);
    }

    @DisplayName("연산기호가 아닌 문자열 입력시 에러 반환합니다.")
    @Test
    void mustThrowIllegalArgumentExceptionInjectedOtherThanOperationMark(){
        assertThatThrownBy(()-> Expression.of("?")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()-> Expression.of("!")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()-> Expression.of("a")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()-> Expression.of("가")).isInstanceOf(IllegalArgumentException.class);
    }
}
