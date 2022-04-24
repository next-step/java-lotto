package lotto.view;

import lotto.domain.Lottos;

public class ResultView {

  private ResultView() {
  }

  public static void printLottos(Lottos lottos) {
    System.out.printf("%d개를 구매했습니다.", lottos.size());
  }
}
