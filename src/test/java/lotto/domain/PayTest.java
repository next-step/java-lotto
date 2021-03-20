package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PayTest {

  @ParameterizedTest
  @ValueSource(ints = {-1000, 900})
  @DisplayName("0보다 작거나, 1000원 단위가 아니라면 IllegalArgsException.")
  void createPayFail(int input) {
    assertThatIllegalArgumentException()
        .isThrownBy(() -> new Pay(input));
  }
}