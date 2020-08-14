import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConverterFactory {

    public static Converter ofConverter(String inputNumbers) {
        final Matcher normalMatcher = Pattern.compile(Constant.NORMAL).matcher(inputNumbers);
        final Matcher customDelimiterMatcher = Pattern.compile(Constant.CUSTOM).matcher(inputNumbers);

        if (customDelimiterMatcher.find()) {
            return new ConverterCustomDelimiterImpl(customDelimiterMatcher);
        }

        if (normalMatcher.find()) {
            return new ConverterImpl(inputNumbers);
        }

        return null;
    }
}
