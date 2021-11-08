package step1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSplitter {

    private final String item;
    private final Pattern customDelimiterPattern;

    private StringSplitter(String item, Pattern customDelimiterPattern) {
        this.item = item;
        this.customDelimiterPattern = customDelimiterPattern;
    }

    public static StringSplitter create(String item, Pattern customDelimiterPattern) {
        return new StringSplitter(item, customDelimiterPattern);
    }

    public Delimiter getDelimiter() {
        Matcher m = this.customDelimiterPattern.matcher(this.item);
        if(!m.find()) {
            return Delimiter.custom(null);
        }
        String symbol = m.group(1);
        return Delimiter.custom(symbol);
    }

//
//    public boolean isExist() {
//        return symbol != null && !symbol.isEmpty();
//    }
//
//    @Override
//    public Delimiter addDelimiter(Delimiter other) {
//        return new StringSplitter(String.format(ADD_FORMAT, this.symbol, other.getSymbol()));
//    }
//
//    @Override
//    public String getSymbol() {
//        return this.symbol;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        StringSplitter basicDelimiter1 = (StringSplitter) o;
//        return Objects.equals(symbol, basicDelimiter1.symbol);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(symbol);
//    }

}
