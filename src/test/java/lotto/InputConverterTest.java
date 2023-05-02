package lotto;

import lotto.domain.InputConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

public class InputConverterTest {
  @ParameterizedTest
  @CsvSource(value = {"14000, 14", "3500, 3", "5000, 5"})
  @DisplayName("입력받은 당첨번호 확인")
  public void checkConvertNumberToList() {
    InputConverter inputConverter = new InputConverter();
    List<Integer> result = inputConverter.convertNumberToList("1, 2, 3, 4, 5, 6");

    assertThat(result.size()).isEqualTo(6);
  }
}
