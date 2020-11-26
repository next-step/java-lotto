package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumberTest {

  private WinningNumber sampleWinningNumber;

  @BeforeEach
  void setUp() {
    String rawInput = "2, 1, 3, 6, 5, 4";
    sampleWinningNumber = WinningNumber.of(rawInput);
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
