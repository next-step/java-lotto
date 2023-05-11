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
    assertThatThrownBy(() -> Parser.parse("1 + 2 * 3 / 2 +"))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("마지막은 항상 피연산자로 끝나야 합니다. 마지막에 입력된 값");
  }

  @Test
  @DisplayName("숫자와 연산자가 번갈아 등장하지 않으면 예외가 발생한다")
  void alternateTest() {
    assertThatThrownBy(() -> Parser.parse("1 + + 2 * 3 / 2 +"))
        .isInstanceOf(NumberFormatException.class);
  }
}