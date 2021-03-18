package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoRankTest {

  @ParameterizedTest
  @ValueSource(ints = {-1, -2, 7})
  @DisplayName("0 ~ 6까지의 랭크 확인")
  public void validateNumber(int input) {
    assertThatIllegalArgumentException().isThrownBy(() -> {
      LottoRank.validateNumber(input);
    });
  }
}
