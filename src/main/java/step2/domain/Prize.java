package step2.domain;

import static java.util.stream.Collectors.toList;
import static step2.util.StringConstant.DELIMITER_COMMA;

import java.util.Arrays;
import java.util.List;

public class Prize {

    private final Game last;

    public Prize(String input) {
        this.last = new Game(toNumbers(input));
    }

    public double profit(Candidate candidate, Seed seed) {
        int sum = 0;
        for (int prizeRank = 3; prizeRank <= 6; ++prizeRank) {
            Integer money = Payout.money(prizeRank);
            Integer count = candidate.count(prizeRank);
            sum += (money * count);
        }
        return (sum * 1.0) / seed.amount();
    }

    public Game last() {
        return this.last;
    }

    private List<Integer> toNumbers(String input) {
        return Arrays.stream(input.split(DELIMITER_COMMA))
            .map(Integer::parseInt)
            .collect(toList());
    }
}
