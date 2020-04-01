package step3.domain;

import java.math.BigDecimal;
import java.util.*;

public class ControlLottoGame {

    public BuyLotto startLotto(int totalPrice) {
        BuyInfo buyInfo = new BuyInfo(totalPrice);
        Lotto lotto = new Lotto();
        return new BuyLotto(lotto, buyInfo.getTotalCount());
    }

    public RankList makeRankListByBuyLotto(WinLotto winLotto, BuyLotto buyLotto) {
        RankList rankList = new RankList(winLotto, buyLotto);
        return rankList;
    }

    public void setResult(ResultInfo resultInfo, RankList rankList) {
        List<HashMap> resultList = new ArrayList<>();
        for (int i = 1; i <= RankInformation.matchWinInformationAllCount(); i++) {
            RankInformation rankInformation = RankInformation.matchWinInformationByIndex(i);
            resultInfo.addProfit(rankInformation.getPrice().multiply(BigDecimal.valueOf(rankList.match(rankInformation))));
        }
    }
}
