package autoLotto.view;

import autoLotto.model.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ResultView {
    private static final String START_RESULT_TEXT = "당첨 통계\n--------------";
    private static final String PROFIT_RATIO_RESULT = "총 수익률은 %.2f 입니다.";
    private static final String START_BRACKET = "[ ";
    private static final String COMMA_DELIMITER = ", ";
    private static final String END_BRACKET = " ]";
    private static final String EMPTY_STRING = "";
    private static final String IS_BONUS_MATCHED = ", 보너스 볼 일치";
    private static final String NO_MATCHED_PRIZE = "당첨된 금액이 없음";

    public void outputPurchasedLottos(LottoPurchaseCount lottoPurchaseCount, LottoMachine lottoMachine) {
        outputPurchasedNumberOfLotto(lottoPurchaseCount.getNumberOfManualLottos(), lottoPurchaseCount.getNumberOfAutoLottos());
        outputPurchasedLottoDetail(lottoMachine);
    }

    private void outputPurchasedNumberOfLotto(int numberOfManualLottos, int numberOfAutoLottos) {
        outputString(String.format("수동으로 %d장, 자동으로 %d장을 구매했습니다.", numberOfManualLottos, numberOfAutoLottos));
    }

    private void outputPurchasedLottoDetail(LottoMachine lottoMachine) {
        List<Lotto> lottos = lottoMachine.getLottos();

        for (Lotto lotto : lottos) {
            outputString(START_BRACKET + convertSetLottoToStringLotto(lotto.getLotto()) + END_BRACKET);
        }
    }

    private String convertSetLottoToStringLotto(Set<LottoNumber> lottoNumbers) {
        return lottoNumbers.stream()
                .map(LottoNumber::getLottoNumber)
                .map(String::valueOf)
                .collect(Collectors.joining(COMMA_DELIMITER));
    }

    private void outputString(String string) {
        if(string != null) {
            System.out.println(string);
        }
    }

    public void outputLottoResult(Map<PrizeEnum, Integer> lottoResult, BigDecimal profit) {
        outputString(START_RESULT_TEXT);
        outputMatchingLottos(lottoResult);
        outputProfit(profit);
    }

    private void outputMatchingLottos(Map<PrizeEnum, Integer> lottoResult) {
        for (PrizeEnum prize : lottoResult.keySet()) {
            outputString(getPrizeResult(prize, lottoResult.get(prize)));
        }
    }

    private String getPrizeResult(PrizeEnum prize, int value) {
        if (prize.getMatchedCount() == PrizeEnum.MISS.getMatchedCount()) {
            return String.format("%s- %d개", NO_MATCHED_PRIZE, value);
        }
        return String.format("%d%s%s (%d) - %d개", prize.getMatchedCount(),"개 일치",getBonusResult(prize), prize.getPrize(), value);
    }

    private String getBonusResult(PrizeEnum prize) {
        if (isBonusMatchedFrom(prize)) {
            return IS_BONUS_MATCHED;
        }

        return EMPTY_STRING;
    }

    private boolean isBonusMatchedFrom(PrizeEnum prize) {
        return prize.isBonusMatched();
    }

    private void outputProfit(BigDecimal profit) {
        String result = String.format(PROFIT_RATIO_RESULT, profit);
        outputString(result);
    }
}
