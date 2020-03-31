package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNoTest {

  @DisplayName("Test for illegal argument")
  @ParameterizedTest
  @ValueSource(ints = {-1, 0, 46})
  public void illegalArgumentTest(int integer) {
    assertThatThrownBy(() -> new LottoNo(integer))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("Test for boundary and middle values and equals method")
  @ParameterizedTest
  @ValueSource(ints = {1, 10, 45})
  public void legalArgumentTest(int integer) {
    assertThat(new LottoNo(integer).equals(new LottoNo(integer))).isTrue();
  }
}
