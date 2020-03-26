package calculator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static calculator.NatualNum.ZERO;

class NatualNumPlusFormula {

    private final List<NatualNum> natualNums;

    NatualNumPlusFormula(List<NatualNum> natualNums) {
        this.natualNums = natualNums;
    }

    NatualNumPlusFormula(String[] tokens) {
        this(Stream.of(tokens)
                .map((Integer::parseInt))
                .map(NatualNum::new)
                .collect(Collectors.toList()));
    }

    int sum() {
        return natualNums.stream()
                .reduce(NatualNum::plus)
                .orElse(ZERO)
                .getNumber();
    }
}
