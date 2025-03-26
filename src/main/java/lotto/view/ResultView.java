package lotto.view;

import lotto.domain.LottoTickets;

public class ResultView {

  public void printLottos(LottoTickets lottoTickets) {
    System.out.println(lottoTickets.size() + "개를 구매했습니다.");
    System.out.println(lottoTickets);
  }

  public void printResult() {
    System.out.println("\n당첨 통계\n---------");
  }
}
