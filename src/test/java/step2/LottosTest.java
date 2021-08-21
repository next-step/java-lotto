package step2;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step2.model.Lotto;
import step2.model.Lottos;

public class LottosTest {

  @Test
  public void Lotto_1개_구매() {
    final int LOTTO_PRICE = 1000;
    final int userAmount = 1000;

    Lottos lottos = new Lottos();

    List lottoNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
    Lotto lotto = new Lotto(lottoNumber);

    for (int i = 0; i < userAmount; i += LOTTO_PRICE) {
      lottos.addLotto(lotto);
    }

    for (int i = 0; i < lottos.getLottosSize(); i += LOTTO_PRICE) {
      assertThat(lottos.getLotto(i).getLottoNumbers()).isEqualTo(lottoNumber);
    }
  }

  @ParameterizedTest
  @ValueSource(ints = {2000, 3000, 14000})
  public void Lotto_N개_구매(int userAmount) {

    final int LOTTO_PRICE = 1000;

    Lottos lottos = new Lottos();

    List lottoNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
    Lotto lotto = new Lotto(lottoNumber);

    for (int i = 0; i < userAmount; i += LOTTO_PRICE) {
      lottos.addLotto(lotto);
    }

    for (int i = 0; i < lottos.getLottosSize(); i++) {
      assertThat(lottos.getLotto(i).getLottoNumbers()).isEqualTo(lottoNumber);
    }
  }
}
