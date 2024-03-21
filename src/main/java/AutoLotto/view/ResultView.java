package autoLotto.view;

import autoLotto.model.Lotto;
import autoLotto.model.LottoMachine;
import autoLotto.model.PrizeResultEnum;

import java.util.HashMap;
import java.util.List;

public class ResultView {
    private static final String START_RESULT_TEXT = "당첨 통계\n--------------";
    private static final String PURCHASED_DONE = "개를 구매했습니다.";
    private static final String ZERO_BENEFIT_RESULT = "총 수익률은 0 입니다.";
    private static final String BENEFIT_RESULT = "총 수익률은 %.2f 입니다.";

    public void outputPurchasedLottos(LottoMachine lottoMachine, int chances) {
        outputPurchasedLottos(chances);
        outputPurchasedLottoDetail(lottoMachine, chances);
    }

    private String outputPurchasedLottos(int chances) {
        return String.format("%d%s.", chances, PURCHASED_DONE);
    }

    private void outputPurchasedLottoDetail(LottoMachine lottoMachine, int chances) {
        List<Lotto> lottos = lottoMachine.getLottos();

        for (Lotto lotto : lottos) {
            outputString(lotto.getLotto().toString());
        }
    }

    private void outputString(String string) {
        System.out.println(string);
    }

    public void outputLottoResult(HashMap<Integer, Integer> lottoResult, float profit) {
        outputString(START_RESULT_TEXT);
        outputMatchingLottos(lottoResult);
        outputProfit(profit);
    }

    private void outputMatchingLottos(HashMap<Integer, Integer> lottoResult) {
        for (Integer key : lottoResult.keySet()) {
            outputString(getPrizeResult(key, lottoResult.get(key)));
        }
    }

    private String getPrizeResult(int index, int value) {
        String prizeDescription = PrizeResultEnum.getDescriptionByIndex(index);

        if (prizeDescription == null) {
            return null;
        }

        return String.format("%s%d",PrizeResultEnum.getDescriptionByIndex(index), value);
    }

    private void outputProfit(float profit) {
        if (profit == 0) {
            outputString(ZERO_BENEFIT_RESULT);
            return;
        }

        String result = String.format(BENEFIT_RESULT, profit);
        outputString(result);
    }
}
