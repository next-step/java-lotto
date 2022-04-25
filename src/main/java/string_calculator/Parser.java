package string_calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class Parser {
    public List<Value> values = new ArrayList<Value>();

    public void parse(String equation) {
        String[] items = equation.split(" ");
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
        if ((Pattern.matches("\\d+", item))) {
            return new Integer(parseInt(item));
        }
        if ((Pattern.matches("[\\+\\-\\*\\/%]", item))) {
            return evaluateOperator(item);
        }
        throw new IllegalArgumentException("Can't evaluate: " + item);
    }

    public Operator evaluateOperator(String value){
        switch (value) {
            case "+": return Operator.PLUS;
            case "-": return Operator.MINUS;
            case "*": return Operator.MULTIPLY;
            case "/": return Operator.DIVIDE;
            case "%": return Operator.MODULO;
        }
        throw new IllegalArgumentException("only [+, -, *, /, %] are allowed.");
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
