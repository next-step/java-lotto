package step2.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ResultLottoGame {

    public static ResultInfo resultLotto(BuyInfo buyInfo, List<Integer> winnerLottoNumber) {
        ResultInfo resultInfo = new ResultInfo();
        WinLotto winLotto = new WinLotto(winnerLottoNumber);
        Iterator<List<Integer>> iterator = BuyInfo.getBuyLottoList().iterator();
        List<Integer> matchCountList = new ArrayList<>();
        while (iterator.hasNext()) {
            matchCountList.add(WinLotto.match((List<Integer>) iterator.next()));
        }
        resultInfo.setInvestPrice(BigDecimal.valueOf(buyInfo.getBuyLottoTotalPrice()));
        resultInfo.setMatchCountList(matchCountList);
        return resultInfo;
    }

    public static ResultInfo setResultString(ResultInfo resultInfo) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 1; i <= 6; i++) {
            getSumData(stringBuffer, resultInfo, i);
        }
        ResultInfo.setResultSentence(stringBuffer);
        ResultInfo.setRate(resultInfo.getProfitPrice().divide(resultInfo.getInvestPrice()));
        return resultInfo;
    }

    private static void getSumData(StringBuffer stringBuffer, ResultInfo resultInfo, int i) {
        WinInformation winInformation = null;
        winInformation = WinInformation.matchWinInformation(i);
        if (winInformation != null) {
            int count = winInformation.getCount();
            BigDecimal price = winInformation.getPrice();
            int matchCount = ResultInfo.match(i);
            stringBuffer.append(count + "개 일치 (" + price + "원)-" + matchCount + "개" + '\n');
            resultInfo.addProfit(price.multiply(BigDecimal.valueOf(matchCount)));
        }
    }

    public static ResultInfo getProfitRate(ResultInfo resultInfo) {
        StringBuffer stringBuffer = resultInfo.getResultSentence();
        stringBuffer.append("총 수익률은 " + resultInfo.getRate() + "입니다. (기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        resultInfo.setResultSentence(stringBuffer);
        return resultInfo;
    }
}
