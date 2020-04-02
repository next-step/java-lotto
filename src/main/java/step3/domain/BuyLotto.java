package step3.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BuyLotto {
    private static final int BONUS_BALL = 5;

    private List<LottoNumberList> buyLottoList;

    public BuyLotto(int totalCount) {
        Lotto lotto = new Lotto();
        List<LottoNumberList> buyLottoList = new ArrayList<>();
        for (int i = 0; i < totalCount; i++) {
            LottoNumberList lottoList = lotto.getRandomLottoList();
            buyLottoList.add(lottoList);
        }
        this.buyLottoList = buyLottoList;
    }

    public List<LottoNumberList> getBuyLottoList() {
        return buyLottoList;
    }

    public List<RankInformation> check(WinLotto winLotto) {
        Iterator<LottoNumberList> iterator = buyLottoList.iterator();
        List<RankInformation> list = new ArrayList<>();
        while (iterator.hasNext()) {
            RankInformation rankInformation = matchWinInformation(winLotto, iterator.next());
            list.add(rankInformation);
        }
        return list;
    }

    private RankInformation matchWinInformation(WinLotto winLotto, LottoNumberList next) {
        int matchCount = winLotto.match(next);
        boolean bonusBallMatch = false;
        if (matchCount == BONUS_BALL) {
            bonusBallMatch = winLotto.matchBonusball(next);
        }
        return RankInformation.matchWinInformation(matchCount, bonusBallMatch);
    }
}
