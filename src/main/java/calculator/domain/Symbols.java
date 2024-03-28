package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Symbols {

    private final List<Symbol> symbols;

    private Symbols(List<Symbol> symbols) {
        this.symbols = symbols;
    }

    public static Symbols create(String[] ops) {
        List<Symbol> list = new ArrayList<>();
        for (int i = 1; i < ops.length; i+=2) {
            list.add(new Symbol(ops[i]));
        }
        return new Symbols(list);
    }

    public String of(int index) {
        return symbols.get(index).getSymbol();
    }
}
