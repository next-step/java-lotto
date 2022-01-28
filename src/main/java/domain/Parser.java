package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {

    private String formula;

    public Parser(String formula) {
        this.formula = formula;
    }

    public List<Integer> splitStringToNumber() {
        return Arrays.asList(formula.split(",|:")).stream()
            .map(Integer::parseInt).collect(
                Collectors.toList());
    }
}
