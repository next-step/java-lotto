package calculator.model.collection;

import calculator.model.Symbol;

public class Symbols extends Collection<Symbol> {

    public Symbol get(int index) {
        return this.values.get(index);
    }
}
