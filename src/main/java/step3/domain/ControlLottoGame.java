package step3.domain;

import java.math.BigDecimal;
import java.util.*;

public class ControlLottoGame {
    private static final int LOTTO_PRICE = 1000;
    private static final int BONUS_BALL = 5;

    public BuyLotto startLotto(int totalPrice) {
        LottoInfo lottoInfo = new LottoInfo(LOTTO_PRICE);
        BuyInfo buyInfo = new BuyInfo(totalPrice, lottoInfo.getLottoPrice());
        Lotto lotto = new Lotto();
        Set<List<LottoNumber>> buyLottoList = new HashSet<>();
        for (int i = 0; i < buyInfo.getTotalCount(); i++) {
            List<LottoNumber> lottoList = lotto.getRandomLottoList();
            buyLottoList.add(lottoList);
        }
        BuyLotto buyLotto = new BuyLotto(buyLottoList);
        return buyLotto;
    }

    public RankList setRanktList(WinLotto winLotto, BuyLotto buyLotto) {
        Iterator<List<LottoNumber>> iterator = buyLotto.getBuyLottoList().iterator();
        List<WinInformation> list = new ArrayList<>();
        while (iterator.hasNext()) {
            WinInformation winInformation = setRank(winLotto, iterator.next());
            list.add(winInformation);
        }
        RankList rankList = new RankList(list);
        return rankList;
    }

    private WinInformation setRank(WinLotto winLotto, List<LottoNumber> next) {
        int matchCount = winLotto.match((List<LottoNumber>) next);
        boolean bonusBallMatch = false;
        if (matchCount == BONUS_BALL) {
            bonusBallMatch = winLotto.matchBonusball((List<LottoNumber>) next);
        }
        return WinInformation.matchWinInformation(matchCount, bonusBallMatch);
    }

    public StringBuffer setResult(ResultInfo resultInfo, RankList rankList) {
        StringBuffer stringBuffer = new StringBuffer("당첨 통계 \n================\n");
        for (int i = 1; i <= WinInformation.matchWinInformationAllCount(); i++) {
            WinInformation winInformation = WinInformation.matchWinInformationByIndex(i);
            BigDecimal price = winInformation.getPrice();
            int count = winInformation.getCount();
            int matchCount = rankList.match(winInformation);
            stringBuffer.append(count + winInformation.getTitle() + "(" + price + "원) - " + matchCount + "개" + '\n');
            resultInfo.addProfit(price.multiply(BigDecimal.valueOf(matchCount)));
        }
        stringBuffer.append("총 수익률은 " + resultInfo.getRate() + "입니다. (기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        return stringBuffer;
    }
}
