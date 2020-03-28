package stringpluscalculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Separators {
    private static final String SPLIT_DELIMITER = "|";

    private List<Separator> separators = Arrays.asList(new Separator(":"), new Separator(","));

    public Separators(String input) {
        if (CustomSeparatorEnum.hasCustomSeparator(input)) {
            String customSeparator = CustomSeparatorEnum.searchCustomSeparator(input);
            this.separators = Arrays.asList(new Separator(customSeparator));
        }
    }

    public String getSplitSeparator() {
        return separators.stream()
                .map(Separator::getSeparator)
                .collect(Collectors.joining(SPLIT_DELIMITER));
    }
}
