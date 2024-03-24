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
        return String.join(COMMA_DELIMITER, lottoNumbers.stream()
                .map(lottoNumber -> lottoNumber.getLottoNumberAsString())
                .collect(Collectors.toList()));
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
        return String.format("%d%s (%d) - %d개", prize.getMatchedCount(),"개 일치", prize.getPrize(), value);
    }

    private void outputProfit(BigDecimal profit) {
        String result = String.format(PROFIT_RATIO_RESULT, profit);
        outputString(result);
    }
}
