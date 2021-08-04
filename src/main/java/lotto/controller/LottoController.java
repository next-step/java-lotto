package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.Message.Message;
import lotto.domain.Lotto;
import lotto.service.LotteryDraw;
import lotto.strategy.RealGenerateLottoNumber;
import lotto.view.InputView;
import lotto.view.LottiesDrawingView;
import lotto.view.ResultView;

public class LottoController {

  public static void main(String[] args) {

    LotteryDraw lotteryDraw = new LotteryDraw(InputView.inputValueWithMessage(Message.MSG_INPUT_MONEY));

    lotteryDraw.buyLotties(new RealGenerateLottoNumber());

    new ResultView(lotteryDraw.getLottiesInfo().getLotties().size());

    Map<Integer, List<Lotto>> matchResult = lotteryDraw.matchLottoInfo(
        lotteryDraw.getLottiesInfo(), lotteryDraw.inputWinningNumbers(
            InputView.inputStringValueWithMessage(Message.MSG_INPUT_WINNER_LOTTO)));

    new LottiesDrawingView(lotteryDraw);

    new ResultView(matchResult,lotteryDraw.gradingScore(matchResult));

  }
}