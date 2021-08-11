package lotto.controller;

import lotto.domain.Lotteries;
import lotto.domain.LottoMoney;
import lotto.domain.LottoResult;
import lotto.domain.WinLottoInfo;
import lotto.message.Message;
import lotto.service.LotteryDraw;
import lotto.service.LottoGameApplication;
import lotto.view.InputView;
import lotto.view.LotteriesDrawingView;
import lotto.view.ResultView;

public class LottoController {

  public static void main(String[] args) {

    LottoMoney lottoMoney = new LottoMoney(
        InputView.inputValueWithMessage(Message.MSG_INPUT_MONEY));

    LottoGameApplication gameApplication = new LottoGameApplication(
        lottoMoney);

    Lotteries lotteries = gameApplication.createLotteries();

    ResultView.drawCountOfBuyLotteries(gameApplication.getNumberOfLotto());

    LotteriesDrawingView.drawLotteriesView(lotteries);

    LotteryDraw lotteryDraw = new LotteryDraw(lottoMoney);

    WinLottoInfo winLottoInfo = lotteryDraw.createWinLottoInfo(
        InputView.inputStringValueWithMessage(Message.MSG_INPUT_WINNER_LOTTO),
        InputView.inputValueWithMessage(Message.MSG_INPUT_BONUS_NUMBER));

    LottoResult result = LottoResult.getResult(winLottoInfo, lotteries);

    ResultView.drawResult(result, lotteryDraw.gradingScore(result));
  }
}