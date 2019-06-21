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

  @DisplayName("쉼표와 콜론 구분자로 입력")
  @Test
  public void splitAndSum_comma_colon() {
    assertThat(Separator.split("1,2:3"))
        .containsExactly("1","2","3");
  }

  @DisplayName("null 이나 빈문자 체크")
  @Test
  public void validateInput() {
    assertThat(Separator.validateInput("")).isTrue();
  }
}
