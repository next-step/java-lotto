package me.daeho.calculator;

import me.daeho.utils.StringUtils;


public class StringAddCalculator {

    public static int splitAndSum(String input) {
        if (StringUtils.isEmpty(input))
            return 0;

        if (StringUtils.isOnlyNumber(input))
            return Integer.parseInt(input);

        return 0;
    }
}
