package calculator.domain.operator;

import java.util.function.BiFunction;

@FunctionalInterface
public interface Operator extends BiFunction<Integer, Integer, Integer> {

}
