package com.seok2.adder.domain;

import com.seok2.common.utils.StringUtils;
import java.util.Arrays;

public class StringAdder {

    public static int sum(String text) {
        if (StringUtils.isBlank(text)) {
            return 0;
        }
        return Arrays.stream(StringUtils.split(text))
            .map(PositiveInteger::parse)
            .reduce(PositiveInteger.ZERO, PositiveInteger::add)
            .intValue();
    }

}
