package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.message.Message;
import lotto.service.LotteryDraw;
import lotto.service.LottoGameApplication;
import lotto.service.Rank;
import lotto.view.InputView;
import lotto.view.LotteriesDrawingView;
import lotto.view.ResultView;

public class LottoController {

  public static void main(String[] args) {

    LottoGameApplication gameApplication = new LottoGameApplication(
        InputView.inputValueWithMessage(Message.MSG_INPUT_MONEY));
    gameApplication.buyLotteries();

    ResultView.drawCountOfBuyLotteries(gameApplication.getNumberOfLotto());

    LotteriesDrawingView.drawLotteriesView(gameApplication);

    LotteryDraw lotteryDraw = new LotteryDraw(gameApplication);

    Map<Rank, List<Lotto>> matchResult = lotteryDraw.matchLottoInfo(
        lotteryDraw.inputWinningNumbers(
            InputView.inputStringValueWithMessage(Message.MSG_INPUT_WINNER_LOTTO)));

    ResultView.drawResult(matchResult, lotteryDraw.gradingScore(matchResult));
  }
}