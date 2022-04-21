package string_calculator;

import java.math.BigDecimal;
import java.nio.file.Path;
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
}
