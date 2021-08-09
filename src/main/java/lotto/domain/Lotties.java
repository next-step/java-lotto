package lotto.domain;

import java.util.*;

public class Lotties {
    private final List<Lotto> lotties;

    public Lotties(List<Lotto> lotties) {
        this.lotties = new ArrayList<>(lotties);
    }

    public int getLottiesSize() {
        return lotties.size();
    }

    public List<Lotto> getLotties() {
        return Collections.unmodifiableList(lotties);
    }

    public void matchLottiesRank(WinningNumbers winningNumber) {
        for (Lotto lotto : lotties) {
            lotto.matchLottoRank(winningNumber);
        }
    }

    public List<RANK> getLottiesRank() {
        List<RANK> rankList = new ArrayList<>();
        for (Lotto lotto : lotties) {
            rankList.add(lotto.getRank());
        }
        return rankList;
    }
}
