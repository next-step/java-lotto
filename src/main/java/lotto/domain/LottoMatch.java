package lotto.domain;

import java.util.*;

public class LottoMatch {

    private Map<RankMatches, Integer> rankOfLotto  = new EnumMap<>(RankMatches.class);

    private void initMap(){
        for(RankMatches rankMatches: RankMatches.values())
            this.rankOfLotto.put(rankMatches,0);
    }

    public void checkRank(BuyLottos buyLottos, WinLotto winLotto){
        initMap();
        for (Lotto lotto: buyLottos.getLottos()) {
            RankMatches rankMatches = lotto.numMatch(winLotto.getWinLottoNum(),winLotto.getBonusNum());
            this.rankOfLotto.put(rankMatches, rankOfLotto.get(rankMatches) + 1);
        }
    }


    public Map<RankMatches, Integer>  getRankOfLotto() {
        return rankOfLotto;
    }
}
