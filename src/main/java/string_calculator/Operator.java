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

public class Operator implements Value {
    private final String value;

    public Operator(String s) {
        if ( Pattern.matches("[^\\+\\-\\*\\/%]", s)) {
            throw new IllegalArgumentException("only [+, -, *, /, %] are allowed.");
        }
        this.value = s;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operator operator = (Operator) o;
        return Objects.equals(value, operator.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
