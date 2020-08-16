import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ConverterFactory {

    public static Optional<Converter> ofConverter(String inputNumbers) {
        List<Converter> converters = Arrays.asList(
                new ConverterCustomDelimiterImpl(inputNumbers),
                new ConverterImpl(inputNumbers));

        return converters.stream()
                .filter(Converter::supports)
                .findFirst();

    }
}
