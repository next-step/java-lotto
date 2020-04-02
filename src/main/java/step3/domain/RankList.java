package step3.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RankList {
    private static final int BONUS_BALL = 5;
    List<RankInformation> rankList;

    public RankList(List<RankInformation> rankList) {
        this.rankList = rankList;
    }

    public RankList(WinLotto winLotto, BuyLotto buyLotto) {
        Iterator<LottoNumberList> iterator = buyLotto.getBuyLottoList().iterator();
        List<RankInformation> list = new ArrayList<>();
        while (iterator.hasNext()) {
            RankInformation rankInformation = matchWinInformation(winLotto, iterator.next());
            list.add(rankInformation);
        }
        this.rankList = list;
    }

    private RankInformation matchWinInformation(WinLotto winLotto, LottoNumberList next) {
        int matchCount = winLotto.match(next);
        boolean bonusBallMatch = false;
        if (matchCount == BONUS_BALL) {
            bonusBallMatch = winLotto.matchBonusball(next);
        }
        return RankInformation.matchWinInformation(matchCount, bonusBallMatch);
    }

    public int match(RankInformation number) {
        return (int) rankList.stream()
                .filter(d -> number == d)
                .count();
    }
}
