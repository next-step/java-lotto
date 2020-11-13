package lotto.domain;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Purchase {
    private final Set<Pick> picks = new HashSet<>();
    private LottoReport report;

    public Set<Pick> getPicks() {
        return picks;
    }

    public void setPicks(Collection<Pick> picks) {
        this.picks.addAll(picks);
    }

    public void setReport(LottoReport report) {
        this.report = report;
    }

    public LottoReport getReport() {
        return report;
    }
}
