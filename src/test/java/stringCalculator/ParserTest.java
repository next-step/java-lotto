package stringCalculator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParserTest {

  @Test
  @DisplayName("처음과 마지막이 숫자가 아니라면 예외가 발생한다")
  void sequenceTest() {
    Parser parser = Parser.getInstance();
    assertThatThrownBy(() -> parser.parse("1 + 2 * 3 / 2 +"))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("연산자는 항상 피연산자 사이에 들어가야 합니다");
  }

  @Test
  @DisplayName("숫자와 연산자가 번갈아 등장하지 않으면 예외가 발생한다")
  void alternateTest() {
    Parser parser = Parser.getInstance();
    assertThatThrownBy(() -> parser.parse("1 + d + 2 * 3 / 2 +"))
        .isInstanceOf(NumberFormatException.class);
  }
}