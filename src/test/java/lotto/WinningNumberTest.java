package lotto;

import static lotto.LottoGameConstant.MINIMUM_LOTTO_NUMBER;
import static lotto.LottoGameConstant.NUMBERS_PER_BUNDLE;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import lotto.lottoexception.DuplicatedNumberException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumberTest {

  private WinningNumber sampleWinningNumber;

  @BeforeEach
  void setUp() {
    String rawInput = "2, 1, 3, 6, 5, 4";
    sampleWinningNumber = WinningNumber.of(LottoNumberBundle.of(rawInput));
  }

  @Test
  @DisplayName("중복 테스트")
  void testDuplication() {
    for (int number = MINIMUM_LOTTO_NUMBER;
        number < MINIMUM_LOTTO_NUMBER + NUMBERS_PER_BUNDLE;
        number++) {

      int finalNumber = number;
      assertThatExceptionOfType(DuplicatedNumberException.class).isThrownBy(
          () -> this.sampleWinningNumber.validateBonusNumberDuplication(LottoNumber.of(finalNumber))
      );
    }
  }
}
