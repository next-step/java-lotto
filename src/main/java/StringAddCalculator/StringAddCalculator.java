package StringAddCalculator;

import StringAddCalculator.utils.CalculateUtil;
import StringAddCalculator.utils.ConditionUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static int splitAndSum(String numbers) {
        int total = 0;
        String[] numberArr;

        if (ConditionUtil.getCheckNullOrEmpty(numbers)) return 0;

        numberArr = numbers.split(",|:");
        numberArr = ConditionUtil.getPatternCustom(numberArr, numbers);

        total = CalculateUtil.getTotalNumber(total, numberArr);

        return total;
    }
}
