package lotto.controller;

import lotto.service.LotteryDraw;
import lotto.view.InputView;
import lotto.view.LottiesDrawing;

public class LottoController {

  public static void main(String[] args) {

    LotteryDraw lotteryDraw = new LotteryDraw(InputView.inputValueWithMessage("구입금액을 입력해 주세요."));
    lotteryDraw.buyLotties();
    lotteryDraw.inputWinningNumbers(InputView.inputStringValueWithMessage("지난주 당첨번호를 입력해 주세요."));

    new LottiesDrawing(lotteryDraw);
  }
}