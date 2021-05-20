package lotto.core.omr;

import lotto.core.SixBall;
import lotto.core.round.Rank;
import lotto.core.round.Round;
import lotto.ui.report.Report;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OmrCard {
    public static final int PRICE = 1000;
    private final List<Omr> omrList;

    public OmrCard() {
        this.omrList = new ArrayList<>();
    }

    public void marking(SixBall sixBall) {
        Omr omr = new Omr(sixBall);
        omrList.add(omr);
    }

    public Map<Rank, List<Omr>> grade(Round round) {
        return omrList.stream().collect(Collectors.groupingBy(x->x.grade(round)));
    }

    public Report getReport(Round round) {
        return new Report(this, round);
    }

    public int size() {
        return omrList.size();
    }

    @Override
    public String toString() {
        return String.format("구입 갯수 : %d\n조회 : %s", size(), omrList.toString());
    }
}
