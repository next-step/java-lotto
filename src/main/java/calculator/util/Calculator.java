package calculator.util;

import calculator.model.Number;
import calculator.model.Numbers;
import calculator.model.Symbol;
import calculator.model.Symbols;

import java.util.List;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Calculator {

    private static Function<List<String>, Stream<String>> convert(IntPredicate isMultipleOfTwo) {
        return command -> IntStream.range(0, command.size())
                .filter(isMultipleOfTwo)
                .mapToObj(command::get);
    }

    private static Function<Stream<String>, Numbers> convertNumbers() {
        return stream -> stream
                .map(Number::new)
                .collect(Numbers::new, Numbers::add, Numbers::addAll);
    }

    private static Function<Stream<String>, Symbols> convertSymbols() {
        return stream -> stream
                .map(Symbol::convert)
                .collect(Symbols::new, Symbols::add, Symbols::addAll);
    }

    public static Number calculate(String value) {
        List<String> command = Splitter.split(value);

        Numbers numbers = convert(index -> index % 2 == 0)
                .andThen(convertNumbers())
                .apply(command);

        Symbols symbols = convert(index -> index % 2 != 0)
                .andThen(convertSymbols())
                .apply(command);


        return numbers.calculate(symbols);
    }
}
