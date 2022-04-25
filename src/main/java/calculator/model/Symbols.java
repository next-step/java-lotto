package calculator.model;

import java.util.ArrayList;

public class Symbols extends Collection<Symbol> {

    public Symbols() {
        this.values = new ArrayList<>();
    }

    @Override
    public void add(Symbol symbol) {
        this.values.add(symbol);
    }

    @Override
    public void addAll(Collection<Symbol> symbols) {
        this.values.addAll(symbols.values);
    }

    public Symbol get(int index) {
        return this.values.get(index);
    }
}
