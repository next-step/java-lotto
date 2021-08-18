package step2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step2.model.Lottos;

public class LottoGameTest {


  @Test
  public void Lotto_1개_구매() {
    int userAmount = 1000;

    Lottos lottos = new Lottos();
    lottos.purchase(userAmount);

    ResultView resultView = new ResultView();
    resultView.printPurchasedLotto(lottos);
  }

  @ParameterizedTest
  @ValueSource(ints = {2000, 3000, 14000})
  public void Lotto_N개_구매(int userAmount) {

    Lottos lottos = new Lottos();
    lottos.purchase(userAmount);

    ResultView resultView = new ResultView();
    resultView.printPurchasedLotto(lottos);
  }
}
