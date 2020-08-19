package step1.domain;

import step1.util.StringUtil;

import java.util.Arrays;

public class StringAddCalculator {

    private static final String DELEMETER = ",|:";

    public static int splitAndSum(String value) {
        if (StringUtil.isEmpty(value)) {
            return 0;
        }

        String[] arrays = StringUtil.splitWithDelemeter(value, DELEMETER);

        if (arrays.length == 1) {
            return StringUtil.StringToInt(arrays[0]);
        }

        return Arrays.stream(arrays).parallel().mapToInt(s -> StringUtil.StringToInt(s)).sum();
    }
}
