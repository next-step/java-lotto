package stringaddcalculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class StringUtilsTest {

  @ParameterizedTest
  @CsvSource(value = {"3dsa,false" , ",true", "'',true", "' ',true"})
  @DisplayName("비어있는(공백 포함) 문자는 true를 반환한다.")
  public void emptyStringIsTrue(String val, boolean expected) {
    System.out.println(val);
    boolean empty = StringUtils.isBlank(val);
    assertThat(empty).isEqualTo(expected);
  }
}