package stringCalculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringSpliterTest {

  @DisplayName("컴마를 기준으로 문자열 분리")
  @Test
  void comma_split() {
    String str = "1,2,3";
    String[] split = StringSpliter.split(str);
    assertThat(split).containsExactly("1","2","3");
  }

  @DisplayName("콜론을 기준으로 문자열 분리")
  @Test
  void colon_split() {
    String str = "1:2:3";
    String[] split = StringSpliter.split(str);
    assertThat(split).containsExactly("1","2","3");
  }

  @DisplayName("컴마와 콜론을 기준으로 문자열 분리")
  @Test
  void comma_colon_split() {
    String str = "1,2:3";
    String[] split = StringSpliter.split(str);
    assertThat(split).containsExactly("1","2","3");
  }

}