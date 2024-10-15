package calculator;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TokenTest {

  @DisplayName("피연산자가 숫자일 때 isOperand() True 반환")
  @Test
  void isOperand_numberInputReturnsTrue() {
    Token token = new Token("2");
    Assertions.assertThat(token.isOperand()).isTrue();
  }

  @DisplayName("피연산자가 숫자가 아닐 때 isOperand() False 반환")
  @Test
  void isOperand_invalidInputReturnsFalse() {
    Token token = new Token("Q");
    Assertions.assertThat(token.isOperand()).isFalse();
  }

  @DisplayName("피연산자가 숫자가 아닐 때 asOperand() 예외 발생")
  @Test
  void asOperand_invalidInputThrowsException() {
    Token token = new Token("Q");
    Assertions.assertThatThrownBy(token::asOperand).isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("연산자가 유효할 때 isOperator() True 반환")
  @Test
  void isOperator_validInputReturnsTrue() {
    Token token = new Token("*");
    Assertions.assertThat(token.isOperator()).isTrue();
  }

  @DisplayName("연산자가 유효하지 않을 때 isOperator() False 반환")
  @Test
  void isOperator_invalidInputReturnsFalse() {
    Token token = new Token("#");
    Assertions.assertThat(token.isOperator()).isFalse();
  }

  @DisplayName("연산자가 유요하지 않을 때 asOperator() 예외 발생")
  @Test
  void asOperator_invalidInputThrowsException() {
    Token token = new Token("@");
    Assertions.assertThatThrownBy(token::asOperator).isInstanceOf(IllegalArgumentException.class);
  }
}