package step2.domain;

import java.util.*;

public class ResultLottoGame {
    public static BuyInfo resultLotto(BuyInfo buyInfo, List<Integer> winnerLottoNumber) {
        WinLotto winLotto = new WinLotto(winnerLottoNumber);

        Iterator iterator = buyInfo.getBuyLottoList().iterator();

        List<Integer> matchCountList = new ArrayList<>();
        while (iterator.hasNext()){
            List<Integer> buyLotto = (List<Integer>)iterator.next();
            int matchCount = WinLotto.match(buyLotto);
            setResult(matchCount);
            matchCountList.add(matchCount);
        }
        buyInfo.setMatchCountList(matchCountList);

        return buyInfo;
    }

    public static Double getProfitRate(int investPrice, int ProfitPrice) {
        double castInvetPrice = (double) investPrice;
        double castProfitPrice = (double) ProfitPrice;
        return (castInvetPrice / castProfitPrice) / 100 ;
    }

    public static void setResult(int matchCount) {
        WinInformation winInformation = null;

        winInformation = winInformation.matchWinInformation(matchCount);
        if(winInformation!=null){

        }
    }
}
