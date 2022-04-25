package calculator.model;

import java.util.ArrayList;
import java.util.List;

public class Symbols {

    private final List<Symbol> symbols;

    public Symbols() {
        this.symbols = new ArrayList<>();
    }

    public void add(Symbol symbol) {
        this.symbols.add(symbol);
    }

    public void addAll(Symbols symbols) {
        this.symbols.addAll(symbols.symbols);
    }

    public Symbol get(int index) {
        return this.symbols.get(index);
    }
}
