package studytest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
}
