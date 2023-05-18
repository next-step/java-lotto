package model.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

import model.lotto.generator.LottoNumberGenerator;
import org.junit.jupiter.api.Test;

public class LottoTest {

  @Test
  void 수동로또는중복된숫자를입력하지말아야한다() {
    assertThatIllegalArgumentException().isThrownBy(() -> {
      new ManualLotto("1, 2, 2, 4, 5, 6");
    });
  }

  @Test
  void 수동로또는6개를입력해야한다() {
    assertThatIllegalArgumentException().isThrownBy(() -> {
      new ManualLotto("1, 2, 3, 4, 5");
    });
  }

  @Test
  void 수동로또구입개수는총로또구매개수보다클수없다() {
    Lottos lottos = new Lottos();
    assertThatIllegalArgumentException().isThrownBy(() -> {
      lottos.buyAutoLotto(2000, 3);
    });
  }

  @Test
  void 구입금액에해당하는로또를발급해야한다() {
    Lottos lottos = new Lottos();
    lottos.buyAutoLotto(5000, 0);
    assertThat(lottos.getAutoLottos()).hasSize(5);
  }

  @Test
  void 로또는1장당6개의번호를랜덤으로생성한다() {
    LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();

    AutoLotto lottoNumber = new AutoLotto(lottoNumberGenerator.create());

    assertThat(lottoNumber.getLotto()).hasSize(6);
  }

  @Test
  void 로또번호는1부터45사이의숫자여야한다_정적팩토리메소드테스트() {
    assertAll(
      () -> assertThat(LottoNo.of(5)).isEqualTo(LottoNo.of(5)),
      () -> assertThat(LottoNo.of(46)).isNull()
    );
  }

  @Test
  void 로또구입금액의백원단위는무시하고구매갯수를정한다() {
    Lottos lottos = new Lottos();
    lottos.buyAutoLotto(12300, 0);
    assertThat(lottos.getAutoLottos()).hasSize(12);
  }

  @Test
  void 로또구입금액은1000원이상이어야한다() {
    Lottos lottos = new Lottos();
    assertThatIllegalArgumentException().isThrownBy(() -> {
      lottos.buyAutoLotto(100, 0);
    });
  }
}
