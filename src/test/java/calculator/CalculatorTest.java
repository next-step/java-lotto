package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {

  private Calculator calculator;

  @BeforeEach
  void setUp() {
    calculator = new Calculator();
  }

  @Test
  void 덧셈() {
    List<Token> tokens = Arrays.asList(
        Token.from("2"),
        Token.from("+"),
        Token.from("3")
    );
    assertThat(calculator.calculate(tokens)).isEqualTo(5);
  }

  @Test
  void 뺄셈() {
    List<Token> tokens = Arrays.asList(
        Token.from("5"),
        Token.from("-"),
        Token.from("3")
    );
    assertThat(calculator.calculate(tokens)).isEqualTo(2);
  }

  @Test
  void 곱셈() {
    List<Token> tokens = Arrays.asList(
        Token.from("4"),
        Token.from("*"),
        Token.from("3")
    );
    assertThat(calculator.calculate(tokens)).isEqualTo(12);
  }

  @Test
  void 나눗셈() {
    List<Token> tokens = Arrays.asList(
        Token.from("6"),
        Token.from("/"),
        Token.from("2")
    );
    assertThat(calculator.calculate(tokens)).isEqualTo(3);
  }

  @Test
  void 복합_연산() {
    List<Token> tokens = Arrays.asList(
        Token.from("2"),
        Token.from("+"),
        Token.from("3"),
        Token.from("*"),
        Token.from("4"),
        Token.from("-"),
        Token.from("6"),
        Token.from("/"),
        Token.from("2")
    );
    assertThat(calculator.calculate(tokens)).isEqualTo(7);
  }

  @Test
  void 지원하지_않는_연산자_사용_시_예외_발생() {
    List<Token> tokens = Arrays.asList(
        Token.from("2"),
        Token.from("^"),
        Token.from("3")
    );
    assertThatThrownBy(() -> calculator.calculate(tokens))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("지원하지 않는 연산자입니다: ^");
  }
} 