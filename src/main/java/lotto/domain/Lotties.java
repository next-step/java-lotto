package lotto.domain;

import java.util.*;

public class Lotties {
    private final List<Lotto> lotties;

    public Lotties(List<Lotto> lotties) {
        this.lotties = new ArrayList<>(lotties);
    }

    public int size() {
        return lotties.size();
    }

    public void matchLottiesRank(WinningNumbers winningNumber) {
        for (Lotto lotto : lotties) {
            lotto.matchLottoRank(winningNumber);
        }
    }

    public List<Lotto> getLotties() {
        return Collections.unmodifiableList(lotties);
    }

    public List<Rank> getLottiesRank() {//리턴타입이 LottoStatistics가 되도록 변경해보자
        List<Rank> rankList = new ArrayList<>();
        for (Lotto lotto : lotties) {
            rankList.add(lotto.getRank());
        }
        return rankList;
    }
}
