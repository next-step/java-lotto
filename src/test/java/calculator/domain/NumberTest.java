package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.exception.InvalidNumberStrException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberTest {

  @Test
  @DisplayName("숫자 제대로 생성되는 지 확인")
  void number() {
    Number number = new Number("100");

    assertThat(number).usingRecursiveComparison().isEqualTo(new Number("100"));
  }

  @Test
  @DisplayName("잘못된 숫자 문자열 일 경우 에러")
  void wrongStr() {
    assertThatThrownBy(() -> {
      Number number = new Number("100123k");
    }).isInstanceOf(InvalidNumberStrException.class);
  }

  @Test
  @DisplayName("Number 클래스 간 덧셈 결과 확인")
  void plus() {
    Number number1 = new Number("100");
    Number number2 = new Number("200");

    assertThat(number1.plus(number2)).usingRecursiveComparison().isEqualTo(new Number(300));
  }

  @Test
  @DisplayName("Number 클래스 간 뺄셈 결과 확인")
  void minus() {
    Number number1 = new Number("100");
    Number number2 = new Number("200");

    assertThat(number1.minus(number2)).usingRecursiveComparison().isEqualTo(new Number(-100));
  }

  @Test
  @DisplayName("Number 클래스 간 곱셈 결과 확인")
  void multiply() {
    Number number1 = new Number("100");
    Number number2 = new Number("200");

    assertThat(number1.multiply(number2)).usingRecursiveComparison().isEqualTo(new Number(20000));
  }

  @Test
  @DisplayName("Number 클래스 간 나눗셈 결과 확인")
  void divide() {
    Number number1 = new Number("100");
    Number number2 = new Number("100");

    assertThat(number1.divide(number2)).usingRecursiveComparison().isEqualTo(new Number(1));
  }
}