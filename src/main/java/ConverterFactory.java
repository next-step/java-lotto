import java.util.Arrays;
import java.util.List;

public class ConverterFactory {

    public static Converter ofConverter(String inputNumbers) {
        List<Converter> converters = Arrays.asList(
                new ConverterCustomDelimiterImpl(inputNumbers),
                new ConverterImpl(inputNumbers));

        return converters.stream()
                .filter(Converter::supports)
                .findFirst()
                .orElse(null);
    }
}
