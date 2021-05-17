package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("String 테스트")
public class StringTest {

  @Test
  @DisplayName("요구사항1 - ,로 다수 문자열 분리 테스트")
  void splitStringTest() {
    String input = "1,2";

    String[] result = input.split(",");
    assertThat(result).contains("1", "2");
  }

  @Test
  @DisplayName("요구사항1 - ,로 단독 문자열을 split 테스트")
  void splitSingleStringTest() {
    String input = "1,";

    String[] result = input.split(",");
    assertThat(result).contains("1");
  }

  @Test
  @DisplayName("요구사항2 - substring으로 ()제거 테스트")
  void substringTest() {
    String input = "(1,2)";
    if (input.contains("(")) {
      input = input.substring(input.indexOf("(") + 1);
    }
    if (input.contains(")")) {
      input = input.substring(0, input.indexOf(")"));
    }
    String[] result = input.split(",");

    assertThat(result).containsExactly("1", "2");
  }

  @Test
  @DisplayName("요구사항3 - charAt을 활용하여 위치를 가져오는 테스트")
  void charatTest() {
    String input = "abc";
    char result = input.charAt(0);

    assertThat(result).isEqualTo("a");
  }

  @Test
  @DisplayName("요구사항3 - charAt예외 발생 테스트")
  void charatExceptionTest() {
    String input = "abc";

    assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
        .isThrownBy(() -> input.charAt(3));
  }

}
