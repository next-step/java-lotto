package lotto.views;

import static lotto.LottoGameConstant.NUM_LOTTO_MESSAGE;

public class ResultView {

  private ResultView() {
  }

  public static void printNumLotto(int numLotto) {
    System.out.print(numLotto);
    System.out.println(NUM_LOTTO_MESSAGE);
  }

  public static void printLottoInfo(String lotto) {
    System.out.print(lotto);
  }
}
