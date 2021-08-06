package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.message.Message;
import lotto.service.LotteryDraw;
import lotto.view.InputView;
import lotto.view.LottiesDrawingView;
import lotto.view.ResultView;

public class LottoController {

  public static void main(String[] args) {

    LotteryDraw lotteryDraw = new LotteryDraw(InputView.inputValueWithMessage(Message.MSG_INPUT_MONEY));

    lotteryDraw.buyLotteries();

    new ResultView(lotteryDraw.getLotteriesInfo().getLottos().size());

    new LottiesDrawingView(lotteryDraw);

    Map<Integer, List<Lotto>> matchResult = lotteryDraw.matchLottoInfo(
        lotteryDraw.getLotteriesInfo(), lotteryDraw.inputWinningNumbers(
            InputView.inputStringValueWithMessage(Message.MSG_INPUT_WINNER_LOTTO)));

    new ResultView(matchResult,lotteryDraw.gradingScore(matchResult));

  }
}