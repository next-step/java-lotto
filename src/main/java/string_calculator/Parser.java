package string_calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class Parser {
    private static String REGEX_INT = "\\d+";
    private static String REGEX_OPERATOR = "[\\+\\-\\*\\/%]";
    private static String EMPTY_STR = " ";
    public List<Value> values = new ArrayList<Value>();

    public void parse(String equation) {
        String[] items = equation.split(EMPTY_STR);
        if (items.length < 1) {
            throw new IllegalArgumentException("Wrong equation: " + items.toString());
        }
        for (String item : items) {
            this.values.add(evaluate(item));
        }
        if (this.values.get(this.values.size() - 1) instanceof Operator ) {
            throw new IllegalArgumentException("Wrong equation, ended with operator");
        }
    }

    private Value evaluate(String item) {
        if ((Pattern.matches(REGEX_INT, item))) {
            return new Integer(parseInt(item));
        }
        if ((Pattern.matches(REGEX_OPERATOR, item))) {
            return Operator.create(item);
        }
        throw new IllegalArgumentException("Can't evaluate: " + item);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parser parser = (Parser) o;
        return Objects.equals(values, parser.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }

    @Override
    public String toString() {
        return "Parser{" +
                "values=" + values +
                '}';
    }
}
