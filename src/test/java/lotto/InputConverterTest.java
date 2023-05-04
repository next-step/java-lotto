package lotto;

import lotto.domain.InputConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.regex.Pattern;

public class InputConverterTest {
  @Test
  @DisplayName("입력받은 당첨번호 확인")
  public void checkConvertNumberToList() {
    InputConverter inputConverter = new InputConverter();
    List<Integer> result = inputConverter.convertNumberToList("1, 2, 3, 4, 5, 6");

    assertThat(result.size()).isEqualTo(6);
  }

  @Test
  @DisplayName("입력받은 당첨번호 확인 - 7예외발생")
  public void checkConvertNumberToList2() {
    InputConverter inputConverter = new InputConverter();
    List<Integer> result = inputConverter.convertNumberToList("1, 2, 3, 4, 5, 6");

    assertThat(result.size()).isEqualTo(6);
  }

  @ParameterizedTest
  @CsvSource(value = {"1, true", "0, false", "45, true", "46, false"})
  @DisplayName("pattern 확인")
  public void patternCheck(String strNumber, boolean expect) {
    Pattern TARGET_NUMBER_PATTERN = Pattern.compile("^[1-9]$|^[1-4][0-5]$");
    boolean result = TARGET_NUMBER_PATTERN.asMatchPredicate().test(strNumber);

    assertThat(result).isEqualTo(expect);

  }
}
