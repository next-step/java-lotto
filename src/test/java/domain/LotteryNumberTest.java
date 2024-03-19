package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LotteryNumberTest {
  private final static int LOWER_BOUND = 1;
  private final static int UPPER_BOUND = 45;

  @ParameterizedTest
  @ValueSource(ints = { LOWER_BOUND - 1, UPPER_BOUND + 1 })
  void 입력_숫자_제한이_있다(int input) {
    Assertions.assertThatThrownBy(() -> new LotteryNumber(PositiveNumber.of(input)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("Wrong constructor argument!");
  }
}
