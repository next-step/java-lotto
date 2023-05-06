package domain.formula;

import static java.lang.Integer.parseInt;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

public class Numbers {

    private final List<Integer> numbers;

    public static final String NUMBER_FORMAT_EXCEPTION = "수식이 옳게 입력되었는지, 숫자 입력 부분을 정확히 확인해주세요.";

    public Numbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Numbers getNumbersByFormula(List<String> formula) {
        return new Numbers(formulaToNumbers(formula));
    }

    private static List<Integer> formulaToNumbers(List<String> formula) {
        return makeNumbersWithEvenElements(formula);
    }

    private static List<Integer> makeNumbersWithEvenElements(List<String> formula) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < formula.size(); i++) {
            evenElementToNumbers(formula, numbers, i);
        }
        return numbers;
    }

    private static void evenElementToNumbers(List<String> formula, List<Integer> numbers, int i) {
        if (i % 2 == 0) {
            numbers.add(getParsedNumberFromFormula(formula, i));
        }
    }

    private static int getParsedNumberFromFormula(List<String> formula, int index) {
        try {
            return parseInt(formula.get(index));
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(NUMBER_FORMAT_EXCEPTION);
        }
    }

    protected Queue<Integer> getNumbersQueue() {
        Queue<Integer> numbers = new LinkedList<>();
        for (int number : this.numbers) {
            numbers.offer(number);
        }
        return numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Numbers numbers1 = (Numbers) o;
        return Objects.equals(numbers, numbers1.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        return "Numbers{" +
                "numbers=" + numbers +
                '}';
    }
}
