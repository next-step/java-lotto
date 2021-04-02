package step2.domain;

import static java.util.stream.Collectors.toList;
import static step2.util.StringConstant.DELIMITER_COMMA;

import java.util.Arrays;
import java.util.List;

public class Prize {

    private final Game last;
    private final Number bonus;

    public Prize(String input, String bonus) {
        this.last = new Game(toNumbers(input));
        this.bonus = new Number(Integer.parseInt(bonus));
    }

    public double profit(Lotto lotto, Seed seed) {
        return lotto.profit() / seed.amount();
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