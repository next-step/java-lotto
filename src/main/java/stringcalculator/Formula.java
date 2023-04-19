package stringcalculator;

import java.security.InvalidParameterException;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Formula {

    public static class SplitFormula {

        public static final Pattern VALID_OPERATIONS = Pattern.compile("^(\\+|-|\\*|\\/)$");
        public static final Pattern VALID_NUMBER = Pattern.compile("\\d");
        public static final String DELIMITER = " ";

        public void split(Formula formula) {
            String[] splitStrings = splitStrings(formula.formula);
            findPrefixZero(splitStrings, formula.numbers);
            findOperations(splitStrings, formula.operators);
            findNumbers(splitStrings, formula.numbers);
            findSuffixZero(splitStrings, formula.numbers);
        }

        private String[] splitStrings(String formula) {
            return formula.split(DELIMITER);
        }

        private void findOperations(String[] splitStrings, Operators operators) {
            for (String splitString : splitStrings) {
                offerOperation(splitString, operators);
            }
        }

        private void findSuffixZero(String[] splitStrings, Numbers numbers) {
            if (isOperation(splitStrings[splitStrings.length - 1])) {
                numbers.offer(new Number("0"));
            }
        }

        private void findNumbers(String[] splitStrings, Numbers numbers) {
            for (String splitString : splitStrings) {
                offerNumber(splitString, numbers);
            }
        }

        private void findPrefixZero(String[] splitStrings, Numbers numbers) {
            if (isOperation(splitStrings[0])) {
                numbers.offer(new Number("0"));
            }
        }

        private void offerNumber(String input, Numbers numbers) {
            if (isNumber(input)) {
                numbers.offer(new Number(input));
            }
        }

        private boolean isNumber(String input) {
            return VALID_NUMBER.matcher(input).find();
        }

        private void offerOperation(String input, Operators operators) {
            if (isOperation(input)) {
                operators.offer(new Operator(input));
            }
        }

        private boolean isOperation(String input) {
            return operationMatcher(input).find();
        }

        private Matcher operationMatcher(String input) {
            return VALID_OPERATIONS.matcher(input);
        }

    }

    private final String formula;
    private final Numbers numbers;
    private final Operators operators;
    private Number result;

    public Formula(String formula) {
        this.formula = validFormula(formula);
        this.numbers = new Numbers(new LinkedList<>());
        this.operators = new Operators(new LinkedList<>());
    }

    private String validFormula(String formula) {
        if (isValid(formula)) {
            throw new InvalidParameterException("빈 수식은 입력할 수 없습니다.");
        }
        return formula;
    }

    private boolean isValid(String formula) {
        return formula == null || formula.isBlank();
    }

    public Queue<Number> numbers() {
        return numbers.clone();
    }

    public Queue<Operator> operations() {
        return operators.clone();
    }

    public void calculate() {
        Number number = numbers.next();
        while (hasNextNumber()) {
            number = calculation(number);
        }
        this.result = number;
    }

    private Number calculation(Number number) {
        return nextOperator().calculation(number, numbers.next());
    }

    private Operator nextOperator() {
        return operators.next();
    }

    private boolean hasNextNumber() {
        return numbers.hasNext();
    }

    public Number result() {
        return result.clone();
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
            formula1.numbers) && Objects.equals(operators, formula1.operators);
    }

    @Override
    public int hashCode() {
        return Objects.hash(formula, numbers, operators);
    }

}
