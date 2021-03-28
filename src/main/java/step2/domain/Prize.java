package step2.domain;

import static java.util.stream.Collectors.toList;
import static step2.util.StringConstant.DELIMITER_COMMA;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Prize {

    private final Game last;
    private final Bonus bonus;

    public Prize(String input, String bonus) {
        this.last = new Game(toNumbers(input));
        this.bonus = new Bonus(toNumber(bonus));
    }

    public double profit(Candidate candidate, Seed seed) {
        AtomicInteger sum = new AtomicInteger();
        Arrays.stream(Rank.values())
            .forEach(rank -> {
                Integer money = rank.getWinningMoney();
                Integer count = candidate.count(rank);
                sum.addAndGet(money * count);
            });
        return (sum.get() * 1.0) / seed.amount();
    }

    public Game last() {
        return this.last;
    }

    public Bonus bonus() {
        return this.bonus;
    }

    private List<Integer> toNumbers(String input) {
        return Arrays.stream(input.split(DELIMITER_COMMA))
            .map(Integer::parseInt)
            .collect(toList());
    }

    private Number toNumber(String bonus) {
        return new Number(Integer.parseInt(bonus));
    }
}
