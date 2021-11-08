package step1;

import java.util.Arrays;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";
    private final Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_PATTERN);

    public int splitAndSum(String input) {
        UserInput userInput = new UserInput(input);
        if (userInput.isNullOrEmpty()) {
            return 0;
        }

        StringSplitter stringSplitter = StringSplitter.create(input, pattern);

        Delimiter delimiter = createDelimiter(stringSplitter);

        String itemString = stringSplitter.getItemString();

        Items items = creatItems(delimiter, itemString);

        return items.sum().getValue();
    }

    private Delimiter createDelimiter(StringSplitter stringSplitter) {
        Delimiter defaultDelimiter = Delimiter.withDefaultDelimiter();
        String customDelimiterSymbol = stringSplitter.getCustomDelimiterSymbol();

        if (customDelimiterSymbol.isEmpty()) {
            return defaultDelimiter;
        }

        return defaultDelimiter.addDelimiter(Delimiter.custom(customDelimiterSymbol));
    }

    private Items creatItems(Delimiter delimiter, String itemString) {
        Items items = new Items();
        String[] splitItemString = itemString.split(delimiter.getSymbol());
        Arrays.stream(splitItemString)
                .map(Item::from)
                .forEach(items::addItem);
        return items;
    }
}
