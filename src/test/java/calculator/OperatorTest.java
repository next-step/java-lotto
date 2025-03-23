package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class OperatorTest {

  @Nested
  @DisplayName("from() 메서드는")
  class FromMethod {

    @Test
    @DisplayName("기호에 맞는 Operator를 반환한다")
    void returnCorrectOperator() {
      assertThat(Operator.from("+")).isEqualTo(Operator.PLUS);
      assertThat(Operator.from("-")).isEqualTo(Operator.MINUS);
      assertThat(Operator.from("*")).isEqualTo(Operator.MULTIPLY);
      assertThat(Operator.from("/")).isEqualTo(Operator.DIVIDE);
    }

    @Test
    @DisplayName("존재하지 않는 기호일 경우 예외를 던진다")
    void throwExceptionForInvalidSymbol() {
      assertThatIllegalArgumentException()
              .isThrownBy(() -> Operator.from("%"))
              .withMessage("잘못된 연산자입니다.");
    }
  }

  @Nested
  @DisplayName("apply() 메서드는")
  class ApplyMethod {

    @Test
    @DisplayName("덧셈을 수행한다")
    void applyPlus() {
      assertThat(Operator.PLUS.apply(2, 3)).isEqualTo(5);
    }

    @Test
    @DisplayName("뺄셈을 수행한다")
    void applyMinus() {
      assertThat(Operator.MINUS.apply(5, 2)).isEqualTo(3);
    }

    @Test
    @DisplayName("곱셈을 수행한다")
    void applyMultiply() {
      assertThat(Operator.MULTIPLY.apply(4, 3)).isEqualTo(12);
    }

    @Test
    @DisplayName("나눗셈을 수행한다")
    void applyDivide() {
      assertThat(Operator.DIVIDE.apply(10, 2)).isEqualTo(5);
    }
  }
}
