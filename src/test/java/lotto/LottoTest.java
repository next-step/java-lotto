package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import org.junit.jupiter.api.Test;

public class LottoTest {

  @Test
  void 로또는1장당6개의번호를랜덤으로생성한다() {
    LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
    lottoNumberGenerator.init();

    List<Integer> lottoNumber = lottoNumberGenerator.create();

    assertThat(lottoNumber).hasSize(6);
  }

  @Test
  void 로또번호는1부터45사이의숫자여야한다() {
    LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
    lottoNumberGenerator.init();

    List<Integer> lottoNumber = lottoNumberGenerator.create();

    assertThat(lottoNumber).allMatch(number -> number < 46 && number > 0);
  }

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
