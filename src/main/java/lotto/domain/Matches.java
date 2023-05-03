package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Matches {

    private final List<Match> matches;

    private Matches(List<Match> matches) {
        this.matches = matches;
    }

    public static Matches of(List<Match> matches) {
        return new Matches(matches);
    }

    public List<Match> getMatches() {
        return Collections.unmodifiableList(matches);
    }
}
