package util;

import java.util.Arrays;

public class Validator {
    /**
     * 0보다 작은수가 존재하는가?
     * @param numbers
     * @return
     */
    public boolean containsMinusNumbers(String[] numbers) {
        int[] minusNumbers = Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .filter(i -> i < 0)
                .toArray();
        return minusNumbers.length > 0;
    }

    /**
     * Null, ""가 없는가?
     * @param parameter
     * @return
     */
    public boolean isNotNullAndNotEmptyString(String parameter) {
        if (parameter == null) {
            return false;
        }
        if (parameter.equals("")) {
            return false;
        }
        return true;
    }
}
