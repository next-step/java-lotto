package step1;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Operators {

    private static final Pattern patternOperate = Pattern.compile("[^\\w\\s]"
);
    private final List<Symbol> symbols = new ArrayList<>();

    public Operators(String string) {
        String[] split = string.split(" ");

        Matcher matcher = patternOperate.matcher(string);
        while (matcher.find()) {
            symbols.add(Symbol.fromString(matcher.group()));
        }
    }

    public List<Symbol> getSymbols() {
        return symbols;
    }

}
