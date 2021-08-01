package stringCalculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringValueTest {

  @DisplayName("equal 값 테스트.")
  @Test
  void equalsValueTest() {
    StringValue targetValue = new StringValue("1");

    assertThat(targetValue).isEqualTo(new StringValue("1"));
  }

}