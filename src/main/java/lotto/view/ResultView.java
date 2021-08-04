package lotto.view;

import lotto.domain.Lotto;
import lotto.service.LotteryDraw;

public class ResultView {

  public ResultView(LotteryDraw lotteryDraw, Lotto lotto) {
    System.out.println("당첨 통계\n"
        + "---------");
    //lotteryDraw.gradingScore(lotteryDraw.matchLottoInfo(lotteryDraw.getLottiesInfo(),lotto));
  }
}
