package stringcalculator;

import java.security.InvalidParameterException;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Formula {

    public static final String DELIMITER = " ";

    private final String formula;
    private final Queue<Number> numbers = new LinkedList<>();
    private final Queue<Operation> operations = new LinkedList<>();
    private Number result;

    public Formula(String formula) {
        if (isValid(formula)) {
            throw new InvalidParameterException("빈 수식은 입력할 수 없습니다.");
        }
        this.formula = formula;
    }

    private boolean isValid(String formula) {
        return formula == null || formula.isBlank();
    }

    public void split() {
        String[] splitStrings = splitStrings();
        findPrefixZero(splitStrings);
        findOperations(splitStrings);
        findNumbers(splitStrings);
        findSuffixZero(splitStrings);
    }

    private String[] splitStrings() {
        return this.formula.split(DELIMITER);
    }

    private void findOperations(String[] splitStrings) {
        for (String splitString : splitStrings) {
            offerOperation(splitString);
        }
    }

    private void findSuffixZero(String[] splitStrings) {
        if (isOperation(splitStrings[splitStrings.length - 1])) {
            numbers.offer(new Number("0"));
        }
    }

    private void findNumbers(String[] splitStrings) {
        for (String splitString : splitStrings) {
            offerNumber(splitString);
        }
    }

    private void findPrefixZero(String[] splitStrings) {
        if (isOperation(splitStrings[0])) {
            numbers.offer(new Number("0"));
        }
    }

    private void offerNumber(String input) {
        if (isNumber(input)) {
            numbers.offer(new Number(input));
        }
    }

    private boolean isNumber(String input) {
        return Number.VALID_NUMBER.matcher(input).find();
    }

    private void offerOperation(String input) {
        if (isOperation(input)) {
            operations.offer(new Operation(input));
        }
    }

    private boolean isOperation(String input) {
        return Operation.VALID_OPERATIONS.matcher(input).find();
    }

    public Queue<Number> numbers() {
        return new LinkedList<>(numbers);
    }

    public Queue<Operation> operations() {
        return new LinkedList<>(operations);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Formula formula1 = (Formula) o;
        return Objects.equals(formula, formula1.formula) && Objects.equals(numbers,
            formula1.numbers) && Objects.equals(operations, formula1.operations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(formula, numbers, operations);
    }

    public void calculate() {
        Number number = numbers.poll();
        while (!numbers.isEmpty()) {
            number = number.calculation(operations.poll(), numbers.poll());
        }
        this.result = number;
    }

    public Number result() {
        return result.clone();
    }

}
