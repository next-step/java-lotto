package studytest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class StringClassTest {

  @DisplayName("1,2를 ,로 split 했을 때 1과 2로 잘 분리되는지 확인")
  @Test
  void splitOneAndTwoByComma() {
    String[] result = "1,2".split(",");
    assertThat(result).containsExactly("1","2");
  }

  @DisplayName("1을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지 확인")
  @Test
  void splitOneByComma() {
    String[] result = "1".split(",");
    assertThat(result).containsExactly("1");
  }

  @DisplayName("(1,2) 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 1,2를 반환하도록 구현한다.")
  @Test
  void subString() {
    String given = "(1,2)";
    int openBracketIndex = given.indexOf("(");
    int closeBracketIndex = given.indexOf(")");

    String result = given.substring(openBracketIndex + 1 , closeBracketIndex);
    assertThat(result).isEqualTo("1,2");
  }

  @DisplayName("abc 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.")
  @CsvSource(value = {"0,a", "1,b", "2,c"})
  @ParameterizedTest
  void carAtInboundTest(int index, char expectation) {
    String given = "abc";
    assertThat(given.charAt(index)).isEqualTo(expectation);
  }

  @DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.")
  @Test
  void charAt() {
    String given = "abc";
    assertThatThrownBy(()->given.charAt(3)).isInstanceOf(StringIndexOutOfBoundsException.class);
  }
}
