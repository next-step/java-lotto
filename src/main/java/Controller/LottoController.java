package Controller;

import Model.*;
import View.Input.InputView;
import View.Result.ResultView;

import java.util.Map;

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

        Lotto[] lottos = new Lotto[count];
        makeAutoLotto(count, lottos);
        ResultBoughtLotto(resultView, lottos);

        //지난주 당첨번호
        WinngNum winngNum = new WinngNum(inputView.inputWinnerLottoNum());

        //당첨규칙
        WinnerRule winnerRule = new WinnerRule();

        //당첨횟수
        WinngCount winngCount = new WinngCount(lottos, winnerRule, winngNum.getWinngNum());

        //당첨통계
        resultView.getEndingMessage();
        resultGetEndingWinnerMessage(resultView, winnerRule.getWinnerRule(), winngCount.getMapPriceCount());

        //당첨된 총 금액
        int priceSum = winngCount.sumPrize();

        //수익률
        Gross gross = new Gross(priceSum, buyAmount);
        resultView.printTotalGross(gross.getGross());
    }

    private static void resultGetEndingWinnerMessage(ResultView resultView, Map<Integer, Integer> mapCountMatchingPrice, Map<Integer, Integer> mapPriceCount) {
        for (Map.Entry<Integer, Integer> entry : mapCountMatchingPrice.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            resultView.printWinnerMessage(key, value, mapPriceCount.get(value));
        }
    }

    public static void makeAutoLotto(int count, Lotto[] lottos) {
        for (int i = 0; i < count; i++) {
            lottos[i] = new Lotto();
            lottos[i].makeRandomLotto();
        }
    }

    private static void ResultBoughtLotto(ResultView resultView, Lotto[] lottos) {
        for (Lotto lotto : lottos) {
            resultView.getLotto(lotto.getLotto());
        }
    }

}
