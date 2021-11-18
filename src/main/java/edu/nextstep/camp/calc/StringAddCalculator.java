package edu.nextstep.camp.calc;

import edu.nextstep.camp.calc.domain.PositiveNumbers;
import edu.nextstep.camp.calc.domain.CommandParser;

public class StringAddCalculator {
    private StringAddCalculator() {}

    public static int splitAndSum(String command) {
        return PositiveNumbers.of(CommandParser.parse(command))
                .sum()
                .toInt();
    }
}
