package calculator.model.collection;

import calculator.model.Symbol;

import java.util.ArrayList;

public class Symbols extends Collection<Symbol> {

    public Symbols() {
        this.values = new ArrayList<>();
    }

    public Symbol get(int index) {
        return this.values.get(index);
    }
}
