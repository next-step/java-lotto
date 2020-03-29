package step2.domain;

import java.math.BigDecimal;
import java.util.*;

public class ControlLottoGame {

    public BuyInfo startLotto(int totalPrice) {
        Lotto lotto = new Lotto();
        BuyInfo buyInfo = new BuyInfo(totalPrice, lotto.getPrice());
        Set<List<Integer>> buyLottoList = new HashSet<>();
        for (int i = 0; i < buyInfo.getBuyLottoCount(); i++) {
            lotto.getLottoNumberList();
            List<Integer> lottoList = lotto.extractLottoNumber();
            buyLottoList.add(lottoList);
        }
        buyInfo.setBuyLottoList(buyLottoList);
        return buyInfo;
    }

    public static ResultInfo resultLotto(BuyInfo buyInfo, List<Integer> winnerLottoNumber) {
        WinLotto winLotto = new WinLotto(winnerLottoNumber);
        Iterator<List<Integer>> iterator = buyInfo.getBuyLottoList().iterator();
        List<Integer> matchCountList = new ArrayList<>();
        while (iterator.hasNext()) {
            matchCountList.add(winLotto.match((List<Integer>) iterator.next()));
        }
        ResultInfo resultInfo = new ResultInfo(BigDecimal.valueOf(buyInfo.getBuyLottoTotalPrice()), matchCountList);
        return resultInfo;
    }

    public static ResultInfo setResultString(ResultInfo resultInfo) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 1; i <= 6; i++) {
            getSumData(stringBuffer, resultInfo, i);
        }
        getProfitRate(resultInfo, stringBuffer);
        return resultInfo;
    }

    private static void getSumData(StringBuffer stringBuffer, ResultInfo resultInfo, int i) {
        WinInformation winInformation;
        winInformation = WinInformation.matchWinInformation(i);
        if (winInformation != null) {
            int count = winInformation.getCount();
            BigDecimal price = winInformation.getPrice();
            int matchCount = resultInfo.match(i);
            stringBuffer.append(count + "개 일치 (" + price + "원)-" + matchCount + "개" + '\n');
            resultInfo.addProfit(price.multiply(BigDecimal.valueOf(matchCount)));
        }
    }

    public static ResultInfo getProfitRate(ResultInfo resultInfo, StringBuffer stringBuffer) {
        stringBuffer.append("총 수익률은 " + resultInfo.getRate() + "입니다. (기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        resultInfo.setResultSentence(stringBuffer);
        return resultInfo;
    }
}
