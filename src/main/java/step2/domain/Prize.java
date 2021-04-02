package step2.domain;

import static java.util.stream.Collectors.toList;
import static step2.util.StringConstant.DELIMITER_COMMA;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Prize {

    private final Game last;
    private final Number bonus;

    public Prize(String input, String bonus) {
        this.last = new Game(toNumbers(input));
        this.bonus = new Number(Integer.parseInt(bonus));
    }

    public double profit(Lotto lotto, Seed seed) {
        Map<Rank, List<Game>> candidate = lotto.candidate();
        AtomicInteger sum = new AtomicInteger();
        Arrays.stream(Rank.values())
            .forEach(rank -> {
                Integer money = rank.getWinningMoney();
                Integer count = candidate.get(rank).size();
                sum.addAndGet(money * count);
            });
        return (sum.get() * 1.0) / seed.amount();
    }

    public Game last() {
        return this.last;
    }

    public Number bonus() {
        return this.bonus;
    }

    private List<Integer> toNumbers(String input) {
        return Arrays.stream(input.split(DELIMITER_COMMA))
            .map(Integer::parseInt)
            .collect(toList());
    }
}