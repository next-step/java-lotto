package autolotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Results {
    private List<Result> results = new ArrayList<>();

    public Results() {
        results.add(new Result(3, 5000));
        results.add(new Result(4, 50000));
        results.add(new Result(5, 1_500_000));
        results.add(new Result(6, 2_000_000_000));
    }

    public Optional<Result> find(int numberOfWins) {
        return results.stream().filter(result -> result.isMatch(numberOfWins)).findFirst();
    }

    public long prize() {
        return results.stream().mapToLong(Result::prize).sum();
    }

    public List<Result> getResults() {
        return results;
    }
}
