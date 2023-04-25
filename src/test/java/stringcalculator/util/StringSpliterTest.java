package stringcalculator.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringSpliterTest {

  @DisplayName("문자열을 공백으로 분리한다.")
  @Test
  public void split_StringArr_String() {
    String input = "hi hi hi";

    String[] retInputArr = StringSpliter.split(input);

    assertThat(retInputArr).hasSize(3);
    assertThat("hi").isIn(retInputArr);
  }
}
