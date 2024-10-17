package calculator.input;

import java.util.ArrayList;
import java.util.List;

public class Symbols {
    private List<Symbol> symbols;
    private Symbol symbol;

    public Symbols() {
        this.symbols = new ArrayList<>();
    }

    public Symbols(List<Symbol> ss) {
        this.symbols = symbols;
    }

    public Symbols generateSymbols(String[] str) {
        for (int i = 0; i < str.length; i++) {
            generateSymbols(str, i);
        }
        return this;
    }

    private void generateSymbols(String[] str, int i) {
        if(isSymbolPosition(i)){
            symbols.add(new Symbol(str[i]));
        }
    }

    private static boolean isSymbolPosition(int i) {
        return (i + 1) % 2 == 0;
    }

    public List<Symbol> getSymbols() {
        return symbols;
    }

}
