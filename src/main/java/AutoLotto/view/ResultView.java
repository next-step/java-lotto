package autoLotto.view;

import autoLotto.model.Lotto;
import autoLotto.model.LottoMachine;
import autoLotto.model.LottoNumber;
import autoLotto.model.PrizeEnum;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ResultView {
    private static final String START_RESULT_TEXT = "당첨 통계\n--------------";
    private static final String PURCHASED_DONE = "개를 구매했습니다.";
    private static final String PROFIT_RATIO_RESULT = "총 수익률은 %.2f 입니다.";
    private static final String START_BRACKET = "[ ";
    private static final String COMMA_DELIMITER = ", ";
    private static final String END_BRACKET = " ]";
    private static final float INIT_PROFIT = 0f;
    private static final String NONE_MATCHED_RESULT = "당첨된 로또가 없습니다.";
    private static final String FIFTH_PRIZE_DESCRIPTION = "3개 일치 (5,000원) - ";
    private static final String FOURTH_PRIZE_DESCRIPTION = "4개 일치 (50,000원) - ";
    private static final String THIRD_PRIZE_DESCRIPTION = "5개 일치 (1,500,000원) - ";
    private static final String SECOND_PRIZE_DESCRIPTION = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String FIRST_PRIZE_DESCRIPTION = "6개 일치 (2,000,000,000원) - ";

    public void outputPurchasedLottos(LottoMachine lottoMachine) {
        outputPurchasedNumberOfLotto(lottoMachine.getNumberOfLottos());
        outputPurchasedLottoDetail(lottoMachine);
    }

    private void outputPurchasedNumberOfLotto(int numberOfLotto) {
        outputString(String.format("%d%s", numberOfLotto, PURCHASED_DONE));
    }

    private void outputPurchasedLottoDetail(LottoMachine lottoMachine) {
        List<Lotto> lottos = lottoMachine.getLottos();

        for (Lotto lotto : lottos) {
            outputString(START_BRACKET + convertSetLottoToStringLotto(lotto.getLotto()) + END_BRACKET);
        }
    }

    private String convertSetLottoToStringLotto(Set<LottoNumber> lottoNumbers) {
        return String.join(COMMA_DELIMITER, lottoNumbers.stream().map(Object::toString).collect(Collectors.toList()));
    }

    private void outputString(String string) {
        if(string != null) {
            System.out.println(string);
        }
    }

    public void outputLottoResult(Map<PrizeEnum, Integer> lottoResult, BigDecimal profit) {
        outputString(START_RESULT_TEXT);
        outputMatchingLottos(lottoResult, profit);
        outputProfit(profit);
    }

    private void outputMatchingLottos(Map<PrizeEnum, Integer> lottoResult, BigDecimal profit) {
        if (profit == BigDecimal.ZERO) {
            outputString(NONE_MATCHED_RESULT);
            return;
        }

        for (PrizeEnum prize : lottoResult.keySet()) {
            outputString(getPrizeResult(prize, lottoResult.get(prize)));
        }
    }

    private String getPrizeResult(PrizeEnum prize, int value) {
        switch(prize.getMatchedCount()) {
            case 3 :
                return String.format("%s%d", FIFTH_PRIZE_DESCRIPTION, value);
            case 4 :
                return String.format("%s%d", FOURTH_PRIZE_DESCRIPTION, value);
            case 5 :
                return getFifthPrizeResult(prize, value);
            case 6 :
                return String.format("%s%d", FIRST_PRIZE_DESCRIPTION, value);
            default :
                return null;
        }
    }

    private String getFifthPrizeResult(PrizeEnum prize, int value) {
        if (prize.isBonusMatched()) {
            return String.format("%s%d", SECOND_PRIZE_DESCRIPTION, value);
        }

        return String.format("%s%d", THIRD_PRIZE_DESCRIPTION, value);
    }

    private void outputProfit(BigDecimal profit) {
        String result = String.format(PROFIT_RATIO_RESULT, profit);
        outputString(result);
    }
}
