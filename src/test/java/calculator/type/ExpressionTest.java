package calculator.type;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ExpressionTest {

  @DisplayName("유효한 표현식 생성자 테스트")
  @Test
  public void constructorWithValidExpression() {
    Expression expression = Expression.valueOf("2 + 3 * 4 / 2");
    assertNotNull(expression);
  }

  @DisplayName("유효하지 않은 표현식 생성자 테스트 (숫자 없음)")
  @Test
  public void constructorWithInValidExpressionFormat1() {
    assertThrows(
        IllegalArgumentException.class,
        () -> Expression.valueOf("3 + 5 *")
    );
  }

  @DisplayName("유효하지 않은 표현식 생성자 테스트 (숫자가 아닌 문자)")
  @Test
  public void constructorWithInValidExpressionFormat2() {
    assertThrows(
        IllegalArgumentException.class,
        () -> Expression.valueOf("3 + A - 2")
    );
  }

  @DisplayName("유효하지 않은 표현식 생성자 테스트 (지원하지 않는 연산자)")
  @Test
  public void constructorWithInValidExpressionFormat3() {
    assertThrows(
        IllegalArgumentException.class,
        () -> Expression.valueOf("3 & 5 - 2")
    );
  }

  @DisplayName("유효하지 않은 표현식 생성자 테스트 (정상적인 표현 식이 하나도 없음)")
  @Test
  public void constructorWithInValidExpressionFormat4() {
    assertThrows(
        IllegalArgumentException.class,
        () -> Expression.valueOf("3 & ")
    );
  }

  @DisplayName("유효하지 않은 표현식 생성자 테스트 (빈값)")
  @Test
  public void constructorWithInValidExpressionFormat5() {
    assertThrows(
        IllegalArgumentException.class,
        () -> Expression.valueOf("")
    );
  }

  @DisplayName("유효하지 않은 표현식 생성자 테스트 (null인 경우)")
  @Test
  public void constructorWithInValidExpressionFormat6() {
    assertThrows(
        IllegalArgumentException.class,
        () -> Expression.valueOf(null)
    );
  }

  @DisplayName("연산 수행")
  @Test
  public void testToIntermediateUnitExpression() {
    assertThat(Expression.valueOf("2 + 3 * 4 / 2").run()).isEqualTo(10);
  }
}
