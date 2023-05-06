package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class Match {

    private static final List<Match> matchCache = new ArrayList<>();
    private static final Match NOT_MATCH = new Match(0, false);

    private final int count;
    private final boolean isBonus;

    static {
        matchCache.add(new Match(0, false));
        matchCache.add(new Match(3, false));
        matchCache.add(new Match(4, false));
        matchCache.add(new Match(5, false));
        matchCache.add(new Match(5, true));
        matchCache.add(new Match(6, false));
    }

    public Match(int count, boolean isBonus) {
        this.count = count;
        this.isBonus = isBonus;
    }

    public static Match from(int count, boolean isBonus) {
        return matchCache.stream()
                .filter(match -> match.isEqual(count, isBonus))
                .findAny()
                .orElse(NOT_MATCH);
    }

    public boolean isEqual(int count, boolean isBonus) {
        return this.count == count && this.isBonus == isBonus;
    }
}


