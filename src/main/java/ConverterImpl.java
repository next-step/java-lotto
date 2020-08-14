public class ConverterImpl implements Converter {
    public static final String DEFAULT_DELIMITER = ",|:";

    private final String inputNumbers;

    public ConverterImpl(String inputNumbers) {
        this.inputNumbers = inputNumbers;
    }

    @Override
    public Number getNumbers(){
        return Number.numbers(inputNumbers.split(DEFAULT_DELIMITER));
    }
}
