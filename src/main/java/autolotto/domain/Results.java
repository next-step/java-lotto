package autolotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Results {
    private List<Result> results = new ArrayList<>();

    public Results() {
        results.add(new Result(3, false));
        results.add(new Result(4, false));
        results.add(new Result(5, false));
        results.add(new Result(5, true));
        results.add(new Result(6, false));
    }

    public Optional<Result> find(int countOfMatch, boolean isBonus) {
        return results.stream()
                .filter(result -> result.isMatch(countOfMatch))
                .filter(result -> result.checkBonus(isBonus))
                .findAny();
    }

    public long prize() {
        return results.stream().mapToLong(Result::prize).sum();
    }

    public List<Result> getResults() {
        return results;
    }
}
