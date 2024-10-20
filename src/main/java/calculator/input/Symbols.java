package calculator.input;

import java.util.ArrayList;
import java.util.List;

public class Symbols {

    private List<Symbol> symbols;

    public Symbols() {
        this.symbols = new ArrayList<>();
    }

    public Symbols generateSymbols(String[] str) {
        for (int i = 0; i < str.length; i++) {
            generateSymbols(str, i);
        }
        return this;
    }

    private void generateSymbols(String[] str, int i) {
        if (isSymbolPosition(i)) {
            symbols.add(Symbol.fromSymbol((str[i])));
        }
    }

    private static boolean isSymbolPosition(int i) {
        return (i + 1) % 2 == 0;
    }

    public List<Symbol> getSymbols() {
        return symbols;
    }

    public int getSize() {
        return symbols.size();
    }

    public String findBySymbol(int idx) {
        return symbols.get(idx).getSymbol();
    }

}
