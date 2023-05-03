package lotto;

import calculator.domain.NumberGroup;
import lotto.domain.InputConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

public class InputConverterTest {
  @ParameterizedTest
  @ValueSource(strings = {"1, 2, 4, 5, 7, 21", "1, 2, 3, 4, 5, 6", "44, 45, 21, 14, 2, 1"})
  @DisplayName("입력받은 당첨번호 List<Integer> 형태로 전환")
  public void checkConvertNumberToList(String str) {
    InputConverter inputConverter = new InputConverter();
    List<Integer> result = inputConverter.convertNumberToList(str);

    assertThat(result.size()).isEqualTo(6);
  }

  @ParameterizedTest
  @CsvSource(value = {"\"46, 2, 3, 4, 5, 6\"", "\"1, 2, 3, 4, 5, 6, 8\"", "\"0, 2, 3, 4, 5, 6\"", "\"2, 2, 3, 4, 5, 6\""})
  @DisplayName("입력받은 당첨번호 List<Integer> 형태로 전환 -> 예외 발생")
  public void checkConvertNumberToListThrowException(String str) {
    InputConverter inputConverter = new InputConverter();

    assertThatThrownBy(() -> inputConverter.convertNumberToList(str))
        .isInstanceOf(IllegalArgumentException.class);
  }
}
