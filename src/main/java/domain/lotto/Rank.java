package domain.lotto;

import java.util.ArrayList;
import java.util.List;

public class Rank {
    private List<Match> matches = new ArrayList<>();

    public List<Match> rankCondition(List<Integer> resultCount) {
        for (int resultOne : resultCount) {
            if (resultOne == 0 || resultOne == 1 || resultOne == 2) {
                matches.add(Match.NONE);
            }
            if (resultOne == 3) {
                matches.add(Match.FIFTH);
            }
            if (resultOne == 4) {
                matches.add(Match.FOURTH);
            }
            if (resultOne == 5) {
                matches.add(Match.THIRD);
            }
            if (resultOne == 7) {
                matches.add(Match.SECOND);
            }
            if (resultOne == 6) {
                matches.add(Match.FIRST);
            }
        }
        return matches;
    }
}
