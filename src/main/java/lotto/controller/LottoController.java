package lotto.controller;

import lotto.domain.Lotteries;
import lotto.domain.LottoMachine;
import lotto.domain.LottoMoney;
import lotto.domain.LottoResult;
import lotto.domain.PurchaseCount;
import lotto.message.Message;
import lotto.service.LotteryDraw;
import lotto.view.InputView;
import lotto.view.LotteriesDrawingView;
import lotto.view.ResultView;

public class LottoController {

  public static void main(String[] args) {

    LottoMoney lottoMoney = new LottoMoney(
        InputView.inputValueWithMessage(Message.MSG_INPUT_MONEY));

    int manualNumber = InputView.inputValueWithMessage(Message.MSG_INPUT_MANUAL_COUNT);

    PurchaseCount purchaseCount = new PurchaseCount(lottoMoney,
        manualNumber);

    Lotteries lotteries = LottoMachine.createLottos(purchaseCount,
        InputView.inputStringValuesWithMessage(Message.MSG_INPUT_MANUAL_LOTTO, manualNumber));

    ResultView.drawCountOfBuyLotteries(purchaseCount);

    LotteriesDrawingView.drawLotteriesView(lotteries);

    LottoResult result = LottoResult.getResult(LotteryDraw.createWinLottoInfo(
        InputView.inputStringValueWithMessage(Message.MSG_INPUT_WINNER_LOTTO),
        InputView.inputValueWithMessage(Message.MSG_INPUT_BONUS_NUMBER)), lotteries);

    ResultView.drawResult(result, LotteryDraw.gradingScore(result, lottoMoney));
  }
}