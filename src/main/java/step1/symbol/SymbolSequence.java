package step1.symbol;

import java.util.ArrayList;
import java.util.List;

public class SymbolSequence<T> {
    private final List<T> symbols;
    private int currIndex;

    public SymbolSequence() {
        this.symbols = new ArrayList<>();
        this.currIndex = 0;
    }

    public void add(T operand) {
        this.symbols.add(operand);
    }

    public T getNext() {
        return this.symbols.get(currIndex++);
    }

    public boolean hasNext() {
        return currIndex < symbols.size();
    }

    public Integer size() {
        return symbols.size();
    }
}
