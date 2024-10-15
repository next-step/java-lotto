package lotto.entity;

import java.util.ArrayList;
import java.util.List;


public class WinningText extends Numbers {
    private static final String DEFAULT_SPLIT_DELIMITER = ",";
    private static final String SPACING_REGEX = " ";

    public WinningText() {

    }

    public List<Integer> numbers(String text) {
        return validate(toInts(split(replaceSpacing(text))));
    }

    private String replaceSpacing(String text) {
        return text.replaceAll(SPACING_REGEX, "");
    }

    private String[] split(String text) {
        return text.split(DEFAULT_SPLIT_DELIMITER);
    }

    private List<Integer> toInts(String[] values) {
        List<Integer> result = new ArrayList<>();
        for (String value : values) {
            Integer winningNumber = toInt(value);
            super.validateRange(winningNumber);
            result.add(winningNumber);
        }
        return result;
    }

    private static Integer toInt(String value) {
        return Integer.parseInt(value);
    }

    private List<Integer> validate(List<Integer> result) {
        super.validateDuplication(result);
        super.validateSize(result);
        return result;
    }
}
