package lotto.core.omr;

import lotto.core.SixBall;
import lotto.core.round.Rank;
import lotto.core.round.Round;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OmrCard {
    private final List<Omr> omrList;
    private final Purchase purchase;

    protected OmrCard(Purchase purchase) {
        this.purchase = purchase;
        this.omrList = new ArrayList<>();
    }

    public void marking(final SixBall sixBall) {
        Omr omr = new Omr(sixBall);
        omrList.add(omr);
    }

    public void auto(final int count) {
        for (int i = 0; i < count; i++) {
            marking(SixBall.valueOf());
        }
    }

    public Map<Rank, List<Omr>> grade(final Round round) {
        return omrList.stream().collect(Collectors.groupingBy(x -> x.grade(round)));
    }

    public int getTotalPrice() {
        return purchase.getTotalPrice();
    }

    public int getAutoCount() {
        return purchase.getAutoCount();
    }

    public int getManualCount() {
        return purchase.getManualCount();
    }

    public Stream<Omr> stream() {
        return omrList.stream();
    }

    @Override
    public String toString() {
        return omrList.toString();
    }
}
