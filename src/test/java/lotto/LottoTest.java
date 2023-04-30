package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;

public class LottoTest {

  @Test
  void 로또구입금액의백원단위는무시하고구매갯수를정한다() {
    int result = Lotto.buy(12300);
    assertThat(result).isEqualTo(12);
  }

  @Test
  void 로또구입금액은1000원이상이어야한다() {
    assertThatIllegalArgumentException().isThrownBy(() -> {
      Lotto.buy(100);
    });
  }

}
