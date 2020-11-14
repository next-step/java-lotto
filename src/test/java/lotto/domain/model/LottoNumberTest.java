package lotto.domain.model;

import lotto.exception.LottoGameException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoNumberTest {

  @ParameterizedTest
  @CsvSource(value = {"1:1", "2:2"}, delimiter = ':')
  void 객체_생성_테스트(String stringInput, int intInput) {
    assertThat(new LottoNumber(stringInput)).isEqualTo(new LottoNumber(intInput));
  }

  @ParameterizedTest
  @ValueSource(strings = {"-1", "a", "46"})
  void 객체_생성_실패_테스트(String stringInput) {
    assertThrows(LottoGameException.class, () -> new LottoNumber(stringInput));
  }

  @ParameterizedTest
  @CsvSource(value = {"1:1", "2:2"}, delimiter = ':')
  void toString_테스트(String stringInput, String expect) {
    assertThat(new LottoNumber(stringInput).toString()).isEqualTo(expect);
  }
}