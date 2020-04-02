package step3.domain;

import java.util.List;

public class Ranks {
    List<RankInformation> ranks;

    public Ranks(List<RankInformation> rankList) {
        this.ranks = rankList;
    }

    public Ranks(WinLotto winLotto, BuyLotto buyLotto) {

        this.ranks = buyLotto.check(winLotto);
    }

    public int match(RankInformation number) {
        return (int) ranks.stream()
                .filter(d -> number == d)
                .count();
    }
}
