package StringAdder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Spliterator {
    private final String DEFAULT_SEPARATOR = "\\,|\\:";
    private final String VERTICAL_BAR = "|";
    private final String INPUT_SEPARATOR = "\\n";
    private final String INDICATOR_OF_CUSTOM_SEPARATOR = "//";
    private final String PREFIX_OF_SEPARATOR = "\\";

    private final int NOT_CONTAIN_INPUT_SEPARATOR = -1;

    private final int POSITION_OF_BEGINNING = 0;
    private final int INCREMENT_AFTER_INPUT_SEPARATOR = 2;

    String input;
    String separator;
    List<String> separatedStrings;
    int currentIndex = 0;

    public Spliterator(String input) {
        this.input = input;
        this.separator = DEFAULT_SEPARATOR;
        this.separatedStrings = separateSeparatorFromInput();
    }

    public Num next() {
        if (!hasNext()) {
            throw new IndexOutOfBoundsException("There is no elements left!");
        }

        int value = getNumberFromRawValue(separatedStrings.get(currentIndex++));
        checkNumberIsAboveZero(value);

        return new Num(value);
    }

    public boolean hasNext() {
        return currentIndex < separatedStrings.size();
    }

    private int getNumberFromRawValue(String rawValue) {
        int value;
        try {
            value = Integer.parseInt(rawValue);
        } catch (Exception e) {
            throw new RuntimeException("Input is not number.");
        }

        return value;
    }

    private void checkNumberIsAboveZero(int value) {
        if (value < 0) {
            throw new RuntimeException("Input is below zero.");
        }
    }

    private List<String> separateSeparatorFromInput() {
        int position = findCustomSeparator();
        if (position != NOT_CONTAIN_INPUT_SEPARATOR) {
             this.separator = addCustomSeparator(position);
             this.input = getInputFromMixed(position);
        }

        return splitInput();
    }

    private List<String> splitInput() {
        return Arrays.stream(input.split(separator))
                .collect(Collectors.toList());
    }

    private int findCustomSeparator() {
        return input.indexOf(INPUT_SEPARATOR);
    }

    private String addCustomSeparator(int position) {
        return DEFAULT_SEPARATOR + VERTICAL_BAR + getCustomSeparator(position);
    }

    private String getCustomSeparator(int position) {
        return input.substring(POSITION_OF_BEGINNING, position)
                .replace(INDICATOR_OF_CUSTOM_SEPARATOR, PREFIX_OF_SEPARATOR);
    }

    private String getInputFromMixed(int position) {
        return input.substring(position+INCREMENT_AFTER_INPUT_SEPARATOR);
    }
}
