package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class StringUtilsTest {

  @Test
  void isBlankTest() {
    //given
    String nullStr = null;
    String emptyStr = "";
    String normalStr = "hello";

    //when
    boolean nullStrResult = StringUtils.isBlank(nullStr);
    boolean emptyStrResult = StringUtils.isBlank(emptyStr);
    boolean normalStrResult = StringUtils.isBlank(normalStr);

    //then
    assertThat(nullStrResult).isTrue();
    assertThat(emptyStrResult).isTrue();
    assertThat(normalStrResult).isFalse();
  }
}
