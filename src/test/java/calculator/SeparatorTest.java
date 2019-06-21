package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SeparatorTest {

  @DisplayName("커스텀 구분자인지 구분")
  @Test
  void isCustomDelimiter() {
    assertThat(Separator.isCustomDelimiter("//;\n1;2;3")).isTrue();
    assertThat(Separator.isCustomDelimiter("1,2:3")).isFalse();
  }

  @DisplayName("커스텀 구분자로 숫자 나눔")
  @Test
  void customDelimiter() {
    assertThat(Separator.splitCustom("//;\n1;2;3"))
        .containsExactly("1","2","3");
  }
}
