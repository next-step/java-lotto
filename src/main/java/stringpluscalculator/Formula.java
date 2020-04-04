package stringpluscalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Formula {
    private List<Operand> operands = Arrays.asList(new Operand(0));

    public Formula(String input, String separators) {
        String inputWithoutCustomSeparator = CustomSeparatorEnum.withoutCustomSeparator(input);
        if (!inputWithoutCustomSeparator.isEmpty()) {
            this.operands = convertPositiveNumber(inputWithoutCustomSeparator.split(separators));
        }
    }

    public int sum() {
        return operands.stream()
                .mapToInt(Operand::getPositiveNumber)
                .reduce(0, Integer::sum);
    }

    private List<Operand> convertPositiveNumber(String[] splitInput) {
        List<Operand> converted = new ArrayList<>();
        for (String s : splitInput) {
            converted.add(new Operand(s));
        }
        return converted;
    }
}
