package lotto.domain;

import lotto.domain.enums.Rank;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Round {
    private final Set<Pick> myPicks = new HashSet<>();
    private LottoReport report;
    private final Set<Integer> winningBalls = new TreeSet<>();

    public Set<Pick> getMyPicks() {
        return myPicks;
    }

    public void addPicks(Collection<Pick> myPicks) {
        this.myPicks.addAll(myPicks);
    }

    public <T> void setWinningBalls(Collection<Integer> winningBalls) {
        this.winningBalls.addAll(winningBalls);
    }

    public Set<Integer> getWinningBalls() {
        return winningBalls;
    }

    public LottoReport generateReport(Integer lottoPrice, Map<Rank, Prize> prizeMap) {
        report = new LottoReport((long) (lottoPrice * myPicks.size()));
        myPicks.stream()
                .map(Pick::getRank)
                .filter(Objects::nonNull)
                .map(prizeMap::get)
                .forEach(report::addPrize);

        return report;
    }
}
