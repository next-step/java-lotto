package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {

  @Test
  void LottoNumber_생성_성공() {
    for (int i = 1 ; i < 46 ; i++) {
      int number = i;
      assertDoesNotThrow(() -> new LottoNumber(number));
    }
  }

  @ParameterizedTest(name = "{0}으로 LottoNumber 생성")
  @ValueSource(ints = {-1, 0, 46})
  void LottoNumber_생성_실패(int invalidNumber) {
    assertThrows(IllegalArgumentException.class, () -> new LottoNumber(invalidNumber));
  }

  @Test
  void toString_성공() {
    LottoNumber lottoNumber = new LottoNumber(1);

    assertThat(lottoNumber.toString()).isEqualTo(String.valueOf(1));
  }

  @Test
  void equals_성공() {
    LottoNumber lottoNumber = new LottoNumber(1);
    LottoNumber other = new LottoNumber(1);
    assertThat(lottoNumber).isEqualTo(other);
  }

  @ParameterizedTest(name = "{0}이랑 비교하여 {1}이 나옴")
  @MethodSource("otherLotto")
  void compareTo_성공(LottoNumber other, int expected) {
    LottoNumber lottoNumber = new LottoNumber(2);

    assertThat(lottoNumber.compareTo(other)).isEqualTo(expected);
  }

  private static Stream<Arguments> otherLotto() {
    return Stream.of(
        Arguments.of(new LottoNumber(1), 1),
        Arguments.of(new LottoNumber(2), 0),
        Arguments.of(new LottoNumber(3), -1)
    );
  }
}
