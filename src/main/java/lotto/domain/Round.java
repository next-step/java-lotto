package lotto.domain;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Round {
    private final Set<Pick> myPicks = new HashSet<>();
    private LottoReport report = new LottoReport();
    private final Set<Integer> winningBalls = new TreeSet<>();

    public Set<Pick> getMyPicks() {
        return myPicks;
    }

    public void addPicks(Collection<Pick> myPicks) {
        this.myPicks.addAll(myPicks);
    }

    public void setReport(LottoReport report) {
        this.report = report;
    }

    public LottoReport getReport() {
        return report;
    }

    public <T> void setWinningBalls(Collection<Integer> winningBalls) {
        this.winningBalls.addAll(winningBalls);
    }

    public Set<Integer> getWinningBalls() {
        return winningBalls;
    }
}
