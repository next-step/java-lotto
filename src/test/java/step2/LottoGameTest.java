package step2;

import org.junit.jupiter.api.Test;

public class LottoGameTest {

  @Test
  public void Lotto_1개_구매() {
    Lotto lotto = new Lotto();
    lotto.draw();

    ResultView resultView = new ResultView();
    resultView.printPurchasedLotto(lotto);
  }
}
