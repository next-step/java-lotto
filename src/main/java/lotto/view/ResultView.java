package lotto.view;

import lotto.domain.Lottos;

public class ResultView {

  private ResultView() {
  }

  public static void printLottos(Lottos lottos) {
    System.out.println(lottos.size() + "개를 구매했습니다.");
    System.out.println(lottos);
  }
}
