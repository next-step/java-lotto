package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.Test;

public class LottoTest {

  @Test
  void 구입금액에해당하는로또를발급해야한다() {
    List<Lotto> lottos = new Lottos().buy(5000);
    assertThat(lottos).hasSize(5);
  }

  @Test
  void 로또번호는1부터45사이의숫자여야한다_로또는1장당6개의번호를랜덤으로생성한다() {
    LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();

    Lotto lottoNumber = new Lotto(lottoNumberGenerator.create());

    assertAll(
        () -> assertThat(lottoNumber.getLotto()).hasSize(6),
        () -> assertThat(lottoNumber.getLotto()).allMatch(number -> number < 46 && number > 0)
    );
  }

  @Test
  void 로또구입금액의백원단위는무시하고구매갯수를정한다() {
    List<Lotto> lottos = new Lottos().buy(12300);
    assertThat(lottos).hasSize(12);
  }

  @Test
  void 로또구입금액은1000원이상이어야한다() {
    Lottos lottos = new Lottos();
    assertThatIllegalArgumentException().isThrownBy(() -> {
      lottos.buy(100);
    });
  }

}
