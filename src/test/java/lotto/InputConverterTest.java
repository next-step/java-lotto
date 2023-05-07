package lotto;

import lotto.utility.InputConverter;
import lotto.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class InputConverterTest {
  @ParameterizedTest
  @ValueSource(strings = {"1, 2, 4, 5, 7, 21", "1, 2, 3, 4, 5, 6", "44, 45, 21, 14, 2, 1"})
  @DisplayName("입력받은 당첨번호 List<Integer> 형태로 전환")
  public void checkConvertNumberToList(String str) {
    List<Integer> result = InputConverter.convertNumberToList(str);

    assertThat(result.size()).isEqualTo(6);
  }

  @ParameterizedTest
  @CsvSource(value = {"\"46, 2, 3, 4, 5, 6\"", "\"1, 2, 3, 4, 5, 6, 8\"", "\"0, 2, 3, 4, 5, 6\"", "\"2, 2, 3, 4, 5, 6\""})
  @DisplayName("입력받은 당첨번호 List<Integer> 형태로 전환 -> 예외 발생")
  public void checkConvertNumberToListThrowException(String str) {
    assertThatThrownBy(() -> InputConverter.convertNumberToList(str))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @ParameterizedTest
  @CsvSource({"1, 1", "45, 45"})
  @DisplayName("입력받은 Bonus번호 1에서 45 숫자만 int 반환 확인")
  public void checkConvertNumber(String str, int expect) {
    int result = InputConverter.convertLottoNumber(str);

    assertThat(result).isEqualTo(expect);
  }

  @ParameterizedTest
  @ValueSource(strings = {"0", "46"})
  @DisplayName("입력받은 Bonus번호 1에서 45 아닌 숫자 예외발생")
  public void checkConvertNumber2(String str) {
    assertThatThrownBy(() -> InputConverter.convertLottoNumber(str))
        .isInstanceOf(IllegalArgumentException.class);
  }
}
