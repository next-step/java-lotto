package step2_pobi.domain;

import java.util.List;

public interface Matchable {

    Rank match(List<Integer> lotto);
}
