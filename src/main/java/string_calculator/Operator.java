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

    public Integer compute(Integer acc, Integer operand) {
        switch (this) {
            case PLUS:
                return new Integer(acc.value() + operand.value());
            case MINUS:
                return new Integer(acc.value() - operand.value());
            case MULTIPLY:
                return new Integer(acc.value() * operand.value());
            case DIVIDE:
                divideByZeroChecker(operand);
                return divideToInteger(acc, operand);
            case MODULO:
                return new Integer(acc.value() % operand.value());
        }
        throw new IllegalArgumentException("Wrong operator was used.");
    }

    private Integer divideToInteger(Integer acc, Integer operand) {
        Boolean isDividable =  acc.value() % operand.value() == 0;
        if (isDividable) {
            return new Integer(acc.value() / operand.value());
        }
        throw new IllegalArgumentException("Can't divide.");
    }

    private void divideByZeroChecker(Integer operand) {
        if (operand.value() == 0) {
            throw new ArithmeticException("Can't divide by Zero.");
        }
    }
}
