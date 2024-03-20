package autoLotto.view;

import autoLotto.model.LottoMachine;
import autoLotto.model.PrizeResultEnum;

public class ResultView {
    private static final String START_RESULT_TEXT = "당첨 통계\n--------------";
    private static final String PURCHASED_DONE = "개를 구매했습니다.";
    private static final String ZERO_BENEFIT_RESULT = "총 수익률은 0 입니다.";
    private static final String BENEFIT_RESULT = "총 수익률은 %.2f 입니다.";
    private static final int LOTTO_PRIZE_START_INDEX = 1;

    public void outputPurchasedLottos(LottoMachine lottoMachine, int chances) {
        outputPurchasedLottos(chances);

        for (int i = 0; i < chances; i++) {
            outputString(lottoMachine.retrieveLotto(i).toString());
        }
    }

    private void outputString(String string) {
        System.out.println(string);
    }

    private String outputPurchasedLottos(int chances) {
        return String.format("%d%s.", chances, PURCHASED_DONE);
    }

    public void outputLottoResult(int[] lottoResult, float profit) {
        outputString(START_RESULT_TEXT);
        outputMatchingLottos(lottoResult);
        outputProfit(profit);
    }

    private void outputMatchingLottos(int[] lottoResult) {
        for (int i = LOTTO_PRIZE_START_INDEX; i < lottoResult.length; i++) {
            outputString(getPrizeResult(i, lottoResult[i]));
        }
    }

    private String getPrizeResult(int index, int value) {
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
