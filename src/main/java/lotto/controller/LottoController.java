package lotto.controller;

import lotto.domain.Lotteries;
import lotto.domain.LottoMoney;
import lotto.domain.LottoResult;
import lotto.domain.PurchaseCount;
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

    PurchaseCount purchaseCount = new PurchaseCount(lottoMoney,
        InputView.inputValueWithMessage(Message.MSG_INPUT_MANUAL_COUNT));

    Lotteries lotteries = LottoGameApplication.createLottos(purchaseCount,
        InputView.inputStringValuesWithMessage(Message.MSG_INPUT_MANUAL_LOTTO, purchaseCount));

    ResultView.drawCountOfBuyLotteries(purchaseCount);

    LotteriesDrawingView.drawLotteriesView(lotteries);

    LottoResult result = LottoResult.getResult(LotteryDraw.createWinLottoInfo(
        InputView.inputStringValueWithMessage(Message.MSG_INPUT_WINNER_LOTTO),
        InputView.inputValueWithMessage(Message.MSG_INPUT_BONUS_NUMBER)), lotteries);

    ResultView.drawResult(result, LotteryDraw.gradingScore(result, lottoMoney));
  }
}