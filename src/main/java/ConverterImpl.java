import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ConverterImpl implements Converter {
    private final Matcher matcher;
    private final String inputNumbers;

    public ConverterImpl(String inputNumbers) {
        this.matcher = Pattern.compile(Constant.NORMAL).matcher(inputNumbers);
        this.inputNumbers = inputNumbers;
    }

    @Override
    public boolean supports() {
        return this.matcher.find();
    }

    @Override
    public CalculationNumber convertInputCalculationNumbers() {
        return new CalculationNumber(
                Arrays.stream(inputNumbers.split(Constant.DEFAULT_DELIMITER))
                        .map(this::toInt)
                        .collect(Collectors.toList()));
    }
}
