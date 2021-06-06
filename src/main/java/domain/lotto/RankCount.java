package domain.lotto;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class RankCount {
    HashMap<Integer, Integer> result = new HashMap<>();

    public HashMap<Integer, Integer> run(List<Match> matches) {
        AtomicInteger equal3 = new AtomicInteger();
        AtomicInteger equal4 = new AtomicInteger();
        AtomicInteger equal5 = new AtomicInteger();
        AtomicInteger equal5AndBonus = new AtomicInteger();
        AtomicInteger equal6 = new AtomicInteger();
        matches.forEach(match -> {
            if (match.equals(Match.FIFTH)) {
                equal3.getAndIncrement();
            }
            if (match.equals(Match.FOURTH)) {
                equal4.getAndIncrement();
            }
            if (match.equals(Match.THIRD)) {
                equal5.getAndIncrement();
            }
            if (match.equals(Match.SECOND)) {
                equal5AndBonus.getAndIncrement();
            }
            if (match.equals(Match.FIRST)) {
                equal6.getAndIncrement();
            }
        });
        result.put(5000, equal3.get());
        result.put(50000, equal4.get());
        result.put(1500000, equal5.get());
        result.put(30000000, equal5AndBonus.get());
        result.put(2000000000, equal6.get());
        return result;
    }
}
