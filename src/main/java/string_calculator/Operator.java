package string_calculator;

import java.math.BigDecimal;
import java.nio.file.Path;
import java.util.Objects;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.regex.Pattern;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public enum Operator implements Value {
    PLUS,
    MINUS,
    MULTIPLY,
    DIVIDE,
    MODULO;

//    private final String value;

//    Operator(String s) {
//        if (Pattern.matches("[^\\+\\-\\*\\/%]", s)) {
//            throw new IllegalArgumentException("only [+, -, *, /, %] are allowed.");
//        }
//        this.value = s;
//    }



//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Operator operator = (Operator) o;
//        return Objects.equals(value, operator.value);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(value);
//    }

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


    public Integer compute(Integer acc, Operator operator, Integer operand) {
//        if (operator.value.equals("+")) {
//            return acc.plus(operand);
//        }
//        if (operator.value.equals("-")) {
//            return acc.minus(operand);
//        }
//        if (operator.value.equals("*")) {
//            return acc.multiply(operand);
//        }
//        if (operator.value.equals("/")) {
//            return acc.divide(operand);
//        }
//        if (operator.value.equals("%")) {
//            return acc.modulo(operand);
//        }

        switch (operator) {
            case PLUS:
                return new Integer(acc.value() + operand.value());
            case MINUS:
                return new Integer(acc.value() - operand.value());
            case MULTIPLY:
                return new Integer(acc.value() * operand.value());
            case DIVIDE:
                if (operand.value() == 0) {
                    throw new ArithmeticException("Can't divide by Zero.");
                }
                Boolean isDividable =  acc.value() % operand.value() == 0;
                if (isDividable) {
                    return new Integer(acc.value() / operand.value());
                }
                throw new IllegalArgumentException("Can't divide.");
            case MODULO:
                return new Integer(acc.value() % operand.value());
        }
        throw new IllegalArgumentException("Wrong operator was used.");
    }
}
