package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {

  @ParameterizedTest
  @ValueSource(ints = {-1, 0, 49, 80})
  @DisplayName("1이상 45 이하의 로또 숫자인지 확인")
  public void validateNumber(int input) {
    assertThatIllegalArgumentException().isThrownBy(() -> { ;
      LottoNumber lottoNumber = new LottoNumber(input);
    });

  }
}
