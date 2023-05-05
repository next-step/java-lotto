package domain.formula;

import static java.lang.Integer.parseInt;

import java.util.ArrayList;
import java.util.List;

public class Numbers {

    private final List<Integer> numbers;


    public Numbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Numbers getNumbersByFormula(List<String> formula) {
        return new Numbers(formulaToNumbers(formula));
    }

    private static List<Integer> formulaToNumbers(List<String> formula) {
        List<Integer> numbers = new ArrayList<>();
        return makeNumbersWithEvenElements(formula, numbers);
    }

    private static List<Integer> makeNumbersWithEvenElements(List<String> formula,
            List<Integer> numbers) {
        for (int i = 0; i < formula.size() / 2; i++) {
            numbers.add(parseInt(formula.get(i * 2)));
        }
        return numbers;
    }
}
