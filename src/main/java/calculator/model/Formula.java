package calculator.model;

import calculator.util.Operator.Symbol;
import calculator.util.SymbolConverter;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Formula {
    private final List<Number> numbers;
    private final List<Symbol> symbols;

    public Formula(List<String> numberAndSymbol) {
        this.numbers = IntStream
                .range(0, numberAndSymbol.size())
                .filter(index -> index % 2 == 0)
                .mapToObj(index -> new Number(numberAndSymbol.get(index)))
                .collect(Collectors.toList());

        this.symbols = IntStream
                .range(0, numberAndSymbol.size())
                .filter(index -> index % 2 != 0)
                .mapToObj(index -> SymbolConverter.convert(numberAndSymbol.get(index)))
                .collect(Collectors.toList());
    }

    public Number calculate() {
        AtomicInteger index = new AtomicInteger();
        return this.numbers
                .stream()
                .reduce((left, right) -> left.calculate(this.symbols.get(index.getAndIncrement()), right))
                .orElseThrow();
    }
}
