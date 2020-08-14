import java.util.regex.Matcher;

public class ConverterCustomDelimiterImpl implements Converter {

    private final Matcher matcher;

    public ConverterCustomDelimiterImpl(Matcher matcher) {
        this.matcher = matcher;
    }

    @Override
    public Number getNumbers(){
        return Number.numbers(matcher.group(2).split(matcher.group(1)));
    }
}
