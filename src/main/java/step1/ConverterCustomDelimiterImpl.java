package step1;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ConverterCustomDelimiterImpl implements Converter {

    private final Matcher matcher;

    public ConverterCustomDelimiterImpl(String inputNumbers) {
        this.matcher = Pattern.compile(Constant.CUSTOM).matcher(inputNumbers);
    }

    @Override
    public boolean supports() {
        return this.matcher.find();
    }

    @Override
    public CalculationNumber convertInputCalculationNumbers() {
        return new CalculationNumber(
                Arrays.stream(matcher.group(2).split(matcher.group(1)))
                        .map(this::toInt)
                        .collect(Collectors.toList()));
    }
}
