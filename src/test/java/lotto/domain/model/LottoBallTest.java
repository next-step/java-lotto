package lotto.domain.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.model.LottoBall;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoBallTest {

  @DisplayName("Test for illegal argument")
  @ParameterizedTest
  @ValueSource(ints = {-1, 0, 46})
  public void illegalArgumentTest(int integer) {
    assertThatThrownBy(() -> new LottoBall(integer))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("Test for boundary and middle values and equals method")
  @ParameterizedTest
  @ValueSource(ints = {1, 10, 45})
  public void legalArgumentTest(int integer) {
    assertThat(new LottoBall(integer).equals(new LottoBall(integer))).isTrue();
  }
}
