package step2;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step2.model.Lotto;
import step2.model.Lottos;

public class LottosTest {

  List lottoNumber;
  int LOTTO_PRICE;

  @BeforeEach
  void setUp() {
    lottoNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
    LOTTO_PRICE = 1000;
  }


  @Test
  public void Lotto_1개_구매() {
    final int userAmount = 1000;

    List<Lotto> lottoList = new ArrayList<>();
    Lotto lotto = new Lotto(lottoNumber);

    for (int i = 0; i < userAmount; i += LOTTO_PRICE) {
      lottoList.add(lotto);
    }

    Lottos lottos = new Lottos(lottoList);

    for (int i = 0; i < lottos.getLottosSize(); i += LOTTO_PRICE) {
      assertThat(lottos.getLotto(i).getLottoNumbers()).isEqualTo(lottoNumber);
    }
  }

  @ParameterizedTest
  @ValueSource(ints = {2000, 3000, 14000})
  public void Lotto_N개_구매(int userAmount) {

    List<Lotto> lottoList = new ArrayList<>();
    Lotto lotto = new Lotto(lottoNumber);

    for (int i = 0; i < userAmount; i += LOTTO_PRICE) {
      lottoList.add(lotto);
    }

    Lottos lottos = new Lottos(lottoList);

    for (int i = 0; i < lottos.getLottosSize(); i++) {
      assertThat(lottos.getLotto(i).getLottoNumbers()).isEqualTo(lottoNumber);
    }
  }
}
