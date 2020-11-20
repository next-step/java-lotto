package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import lotto.lottoexception.IllegalLottoNumberRangeException;
import lotto.lottoexception.InvalidLottoFormatException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningNumberTest {

  private WinningNumber sampleWinningNumber;

  @BeforeEach
  void setUp() {
    String rawInput = "2, 1, 3, 6, 5, 4";
    sampleWinningNumber = NumberPool.publishWinningNumber(rawInput);
  }

  @Test
  @DisplayName("범위를 벗어난 입력")
  void testOutOfRange() {
    String input = "1, 2, 3, 4, 5, 46";
    assertThatExceptionOfType(IllegalLottoNumberRangeException.class).isThrownBy(
        () -> NumberPool.publishWinningNumber(input)
    );
  }

  @Test
  @DisplayName("중복된 번호 입력")
  void testDuplicatedInput() {
    String input = "1, 2, 3, 4, 5, 5";
    assertThatExceptionOfType(InvalidLottoFormatException.class).isThrownBy(
        () -> NumberPool.publishWinningNumber(input)
    );
  }

  @ParameterizedTest
  @ValueSource(strings = {"1, 2, 3, 4, 5", "1, 2, 3, 4, 5, 6, 7"})
  @DisplayName("길이가 맞지 않는 입력")
  void testInvalidLength(String input) {
    assertThatExceptionOfType(InvalidLottoFormatException.class).isThrownBy(
        () -> NumberPool.publishWinningNumber(input)
    );
  }

  @Test
  @DisplayName("Iterable Test")
  void testIterable() {
    int idx = 1;
    for (LottoNumber number : this.sampleWinningNumber) {
      assertThat(number).isEqualTo(LottoNumber.of(idx));
      idx += 1;
    }
  }
}
