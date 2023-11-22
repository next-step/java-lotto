package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Result {

    private final List<Rank> result = new ArrayList<>();

    public Result() {
    }

    public void add(Rank rank) {
        result.add(rank);
    }

    public int countRank(Rank value) {
        return (int) result.stream().filter(n -> n.equals(value)).count();
    }
}
