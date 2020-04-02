package step3.domain;

import java.math.BigDecimal;

public class ControlLottoGame {

    public BuyLotto startLotto(int totalPrice) {
        BuyInfo buyInfo = new BuyInfo(totalPrice);
        return new BuyLotto(buyInfo.getTotalCount());
    }

    public Ranks makeRankListByBuyLotto(WinLotto winLotto, BuyLotto buyLotto) {
        Ranks ranks = new Ranks(winLotto, buyLotto);
        return ranks;
    }

    public void setResult(ResultInfo resultInfo, Ranks ranks) {
        for (int i = 1; i <= RankInformation.matchWinInformationAllCount(); i++) {
            RankInformation rankInformation = RankInformation.matchWinInformationByIndex(i);
            resultInfo.addProfit(rankInformation.getPrice().multiply(BigDecimal.valueOf(ranks.match(rankInformation))));
        }
    }
}
