package lotto_step1;

import java.util.ArrayList;
import java.util.List;

public class CalculatorSum {
    private static List<Integer> intSplitValues = new ArrayList<>();

    public static int sum(List<String> splitValues) {
        if (splitValues.size() <= 0 || splitValues.contains("")) {
            return CalculatorConstants.NUMBER_ZERO;
        }
        getSplitValues(splitValues);
        return intSplitValues.stream().mapToInt(Integer::intValue).sum();
    }

    private static List<Integer> getSplitValues(List<String> splitValues) {
        for(String splitValue : splitValues) {
            intSplitValues.add(Integer.parseInt(splitValue));
        }
        return intSplitValues;
    }
}
