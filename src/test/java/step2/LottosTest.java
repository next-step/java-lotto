package step2;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step2.model.lotto.Lotto;
import step2.model.lotto.LottoNo;
import step2.model.lotto.LottoNos;
import step2.model.lotto.Lottos;

public class LottosTest {

  List<LottoNo> lottoNoList;
  int LOTTO_PRICE;

  @BeforeEach
  void setUp() {
    LOTTO_PRICE = 1000;
    lottoNoList = new ArrayList<>();
    int[] lottoNos = {1, 2, 3, 4, 5, 6};

    for (int i = 0; i < lottoNos.length; i++) {
      lottoNoList.add(new LottoNo(lottoNos[i]));
    }
  }

  @Test
  public void Lotto_1개_구매() {
    final int userAmount = 1000;

    List<Lotto> lottoList = new ArrayList<>();
    LottoNos lottoNos = new LottoNos(lottoNoList);
    Lotto lotto = new Lotto(lottoNos);

    for (int i = 0; i < userAmount; i += LOTTO_PRICE) {
      lottoList.add(lotto);
    }

    Lottos lottos = new Lottos(lottoList);

    for (int i = 0; i < lottos.getLottosSize(); i += LOTTO_PRICE) {
      assertThat(lottos.getLotto(i).getLottoNos())
          .isEqualToComparingFieldByField(new LottoNos(lottoNoList));
    }
  }

  @ParameterizedTest
  @ValueSource(ints = {2000, 3000, 14000})
  public void Lotto_N개_구매(int userAmount) {

    List<Lotto> lottoList = new ArrayList<>();
    LottoNos lottoNos = new LottoNos(lottoNoList);
    Lotto lotto = new Lotto(lottoNos);

    for (int i = 0; i < userAmount; i += LOTTO_PRICE) {
      lottoList.add(lotto);
    }

    Lottos lottos = new Lottos(lottoList);

    for (int i = 0; i < lottos.getLottosSize(); i++) {
      assertThat(lottos.getLotto(i).getLottoNos())
          .isEqualToComparingFieldByField(new LottoNos(lottoNoList));
    }
  }
}
