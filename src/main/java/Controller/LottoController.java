package Controller;

import Model.*;
import View.Input.InputView;
import View.Result.ResultView;

public class LottoController {
    private static int LOTT_PRICE = 1000;

    public static void LottoAutoStart() {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        //구입금액
        int buyAmount = inputView.getInputBuyAmount();

        //갯수
        int count = new Price(LOTT_PRICE).getCount(buyAmount);
        resultView.resultBuyInputCount(count);

        //로또 만들기
        LottoRandomGenerator lottoGenerator = new LottoRandomGenerator();
        lottoGenerator.generatorLotto(count);
        resultView.getLotto(lottoGenerator.getLottos());

        //지난주 당첨번호
        WinNum winNum = new WinNum(inputView.inputWinnerLottoNum());

        //당첨규칙
        WinRule winRule = new WinRule();

        //당첨횟수
        WinCount winCount = new WinCount(winRule, lottoGenerator.getLottos(), winNum);

        //당첨통계
        LotteryStatics lotteryStatics = new LotteryStatics(winRule, winCount);
        resultView.getEndingMessage();
        for (int[] result : lotteryStatics.getLotteryStatics()) {
            resultView.printWinnerMessage(result[0], result[1], result[2]);
        }

        //당첨된 총 금액
        int priceSum = lotteryStatics.getSumPirze();

        //수익률
        Gross gross = new Gross(priceSum, buyAmount);
        resultView.printTotalGross(gross.getGross());
    }
}
