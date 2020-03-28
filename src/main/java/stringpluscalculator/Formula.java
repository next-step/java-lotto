package stringpluscalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Formula {
    private List<PositiveNumber> positiveNumbers = Arrays.asList(new PositiveNumber(0));

    public Formula(String input, String separators) {
        String inputWithoutCustomSeparator = CustomSeparatorEnum.withoutCustomSeparator(input);
        if (!inputWithoutCustomSeparator.isEmpty()) {
            this.positiveNumbers = convertPositiveNumber(inputWithoutCustomSeparator.split(separators));
        }
    }

    public int sum() {
        return positiveNumbers.stream()
                .mapToInt(PositiveNumber::getPositiveNumber)
                .reduce(0, Integer::sum);
    }

    private List<PositiveNumber> convertPositiveNumber(String[] splitInput) {
        List<PositiveNumber> converted = new ArrayList<>();
        for (String s : splitInput) {
            converted.add(new PositiveNumber(s));
        }
        return converted;
    }
}
