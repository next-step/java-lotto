package autoLotto.view;

import autoLotto.model.Lotto;
import autoLotto.model.LottoMachine;
import autoLotto.model.LottoNumber;
import autoLotto.model.PrizeResultEnum;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ResultView {
    private static final String START_RESULT_TEXT = "당첨 통계\n--------------";
    private static final String PURCHASED_DONE = "개를 구매했습니다.";
    private static final String ZERO_REWARD_RESULT = "당첨된 상금이 없습니다.";
    private static final String PROFIT_RATIO_RESULT = "총 수익률은 %.2f 입니다.";
    private static final String START_BRACKET = "[ ";
    private static final String COMMA_DELIMITER = ", ";
    private static final String END_BRACKET = " ]";
    private static final String THREE_MATCHED_DESCRIPTION = "3개 일치 (5,000원) - ";
    private static final String FOUR_MATCHED_DESCRIPTION = "4개 일치 (50,000원) - ";
    private static final String FIVE_MATCHED_DESCRIPTION = "5개 일치 (1,500,000원) - ";
    private static final String SIX_MATCHED_DESCRIPTION = "6개 일치 (2,000,000,000원) - ";

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
        System.out.println(string);
    }

    public void outputLottoResult(Map<Integer, Integer> lottoResult, float profit) {
        outputString(START_RESULT_TEXT);
        outputMatchingLottos(lottoResult);
        outputProfit(profit);
    }

    private void outputMatchingLottos(Map<Integer, Integer> lottoResult) {
        if (lottoResult.size() == 0) {
            outputString(ZERO_REWARD_RESULT);
            return;
        }

        for (Integer key : lottoResult.keySet()) {
            outputString(getPrizeResult(key, lottoResult.get(key)));
        }
    }

    private String getPrizeResult(int matchedNumber, int value) {
        switch(matchedNumber) {
            case 3 :
                return String.format("%s%d", THREE_MATCHED_DESCRIPTION, value);
            case 4 :
                return String.format("%s%d", FOUR_MATCHED_DESCRIPTION, value);
            case 5 :
                return String.format("%s%d", FIVE_MATCHED_DESCRIPTION, value);
            case 6 :
                return String.format("%s%d", SIX_MATCHED_DESCRIPTION, value);
            default :
                return null;
        }
    }

    private void outputProfit(float profit) {
        String result = String.format(PROFIT_RATIO_RESULT, profit);
        outputString(result);
    }
}
