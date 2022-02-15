package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class User {

    private final List<Lotto> lottos;

    public User(List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    public List<MatchInfo> findEachLottoMatchingNumber(WinningNumber winningNumber) {
        List<MatchInfo> matchInfos = new ArrayList<>();
        for (Lotto lotto : lottos) {
            matchInfos.add(lotto.matchLottoWithWinningNumber(winningNumber));
        }
        return matchInfos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

}
