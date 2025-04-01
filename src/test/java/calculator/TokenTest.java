package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class TokenTest {

  @Test
  void 숫자_토큰_생성() {
    Token token = Token.from("123");
    assertThat(token.getValue()).isEqualTo("123");
    assertThat(token.isNumeric()).isTrue();
    assertThat(token.isOperator()).isFalse();
    assertThat(token.isNotValid()).isFalse();
    assertThat(token.toInt()).isEqualTo(123);
  }

  @Test
  void 연산자_토큰_생성() {
    Token token = Token.from("+");
    assertThat(token.getValue()).isEqualTo("+");
    assertThat(token.isNumeric()).isFalse();
    assertThat(token.isOperator()).isTrue();
    assertThat(token.isNotValid()).isFalse();
    assertThatThrownBy(token::toInt)
        .isInstanceOf(NumberFormatException.class);
  }

  @Test
  void 유효하지_않은_토큰_생성() {
    Token token = Token.from("^");
    assertThat(token.getValue()).isEqualTo("^");
    assertThat(token.isNumeric()).isFalse();
    assertThat(token.isOperator()).isFalse();
    assertThat(token.isNotValid()).isTrue();
    assertThatThrownBy(token::toInt)
        .isInstanceOf(NumberFormatException.class);
  }

  @Test
  void 모든_연산자_토큰_테스트() {
    String[] operators = {"+", "-", "*", "/"};
    for (String operator : operators) {
      Token token = Token.from(operator);
      assertThat(token.isOperator()).isTrue();
      assertThat(token.isNumeric()).isFalse();
      assertThat(token.isNotValid()).isFalse();
    }
  }
} 