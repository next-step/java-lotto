import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Numbers {

    private final static String DEFAULT_DELIMITER = ",|:";
    private final static String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";

    private final List<Number> numbers;

    public Numbers(String input) {
        this.numbers = createNumbers(input);
    }

    public Numbers(Number... numbers) {
        /* For Test */
        this.numbers = new ArrayList<>();
        this.numbers.addAll(Arrays.asList(numbers));
    }


    public Number calculateAddAll() {
        Number result = new Number(0);

        for(Number number : numbers) {
            result = result.plus(number);
        }

        return result;
    }

    private List<Number> createNumbers(String stringInput) {
        List<Number> numbers = new ArrayList<>();
        String[] stringNumbers = parseToStringNumber(stringInput);

        if (stringNumbers == null) {
            return createSingleNumbers(stringInput);
        }

        for(String stringNumber : stringNumbers) {
            numbers.add(new Number(stringNumber));
        }

        return numbers;
    }


    private String[] parseToStringNumber(String inputString) {
        if (isEmpty(inputString)) {
            return null;
        }

        Matcher delimiterMatcher = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(inputString);
        String numberPart = inputString;
        String delimiter = DEFAULT_DELIMITER;

        if (delimiterMatcher.find()) {
            delimiter = delimiterMatcher.group(1);
            numberPart = delimiterMatcher.group(2);
        }

        return numberPart.split(delimiter);
    }

    private boolean isEmpty(String inputString) {
       return inputString == null
               || inputString.trim().isEmpty();
    }

    private List<Number> createSingleNumbers(String inputString) {
        List<Number> numbers = new ArrayList<>();
        numbers.add(new Number(inputString));
        return numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Numbers numbers1 = (Numbers) o;
        return Objects.equals(numbers, numbers1.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
