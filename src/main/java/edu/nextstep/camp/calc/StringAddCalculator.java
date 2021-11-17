package edu.nextstep.camp.calc;

import edu.nextstep.camp.calc.domain.Adder;
import edu.nextstep.camp.calc.domain.CommandParser;

public class StringAddCalculator {
    public static int splitAndSum(String command) {
        return Adder.add(CommandParser.parse(command))
                .toInt();
    }
}
