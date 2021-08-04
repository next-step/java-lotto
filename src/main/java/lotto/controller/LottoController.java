package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.service.LotteryDraw;
import lotto.view.InputView;
import lotto.view.LottiesDrawingView;
import lotto.view.ResultView;

public class LottoController {

  public static void main(String[] args) {

    LotteryDraw lotteryDraw = new LotteryDraw(InputView.inputValueWithMessage("구입금액을 입력해 주세요."));

    Lotto lotto = lotteryDraw.inputWinningNumbers(
        InputView.inputStringValueWithMessage("지난주 당첨번호를 입력해 주세요."));

    new LottiesDrawingView(lotteryDraw);

    Map<Integer, List<Lotto>> matchResult = lotteryDraw.matchLottoInfo(
        lotteryDraw.getLottiesInfo(), lotto);


    new ResultView(matchResult,lotteryDraw.gradingScore(matchResult));

  }
}