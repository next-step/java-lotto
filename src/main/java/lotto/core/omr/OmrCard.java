package lotto.core.omr;

import lotto.core.SixBall;
import lotto.core.round.Rank;
import lotto.core.round.Round;
import lotto.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OmrCard {
    private final List<Omr> omrList;

    public OmrCard() {
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

    public int size() {
        return omrList.size();
    }

    public Stream<Omr> stream() {
        return omrList.stream();
    }

    @Override
    public String toString() {
        return omrList.toString();
    }
}
