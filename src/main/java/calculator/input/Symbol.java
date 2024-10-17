package calculator.input;


import java.util.ArrayList;
import java.util.List;

public class Symbol {
    private static final String add = "+";
    private static final String sub = "-";
    private static final String mul = "*";
    private static final String div = "/";

    private String symbol;

    public Symbol(String symbol) {
        if(symbol.isEmpty()){
            throw new IllegalArgumentException("기호에 빈 값이 존재합니다.");
        }
        if(!checkSymbols().contains(symbol)){
            throw new IllegalArgumentException("연산 가능한 기호가 아닙니다.");
        }
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public static List<String> checkSymbols() {
        List<String> symbols = new ArrayList<>();
        symbols.add(add);
        symbols.add(sub);
        symbols.add(mul);
        symbols.add(div);
        return symbols;
    }

}
