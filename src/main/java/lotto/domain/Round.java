package lotto.domain;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Round {
    private final Set<Pick> myPicks = new HashSet<>();
    private final Set<Integer> winningNumbers = new TreeSet<>();
    private LottoReport report;

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

    public void setWinningNumbers(Collection<Integer> winningNumbers) {
        this.winningNumbers.addAll(winningNumbers);
    }

    public Set<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
