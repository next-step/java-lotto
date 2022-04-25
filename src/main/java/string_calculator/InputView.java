package string_calculator;

import java.util.*;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);
    public List<Value> values = new ArrayList<Value>();

    public String scan() {
        System.out.println("Put your equation.");
        return scanner.nextLine();
    }

    public void parse(String equation) {
        String[] items = equation.split(" ");
        if (items.length < 1) {
            throw new IllegalArgumentException("Wrong equation: " + items.toString());
        }
        for (String item : items) {
            this.values.add(evaluate(item));
//            try {
//                Operator o = evaluateOperator(item);
//                this.values.add(o);
//            } catch (Exception e) {
//                evaluateInteger(item);
//            }
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


//    private static Operator evaluateOperator(String item) {
//        return new Operator(item);
//    }
//
//    private void evaluateInteger(String item) {
//        try {
//            Integer i = new Integer(parseInt(item));
//            this.values.add(i);
//        } catch (Exception e) {
//            throw e;
//        }
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InputView inputView = (InputView) o;
        return Objects.equals(values, inputView.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }

    @Override
    public String toString() {
        return "InputView{" + "values=" + values + '}';
    }
}
