package edu.nextstep.calculate;

import java.util.Arrays;
import java.util.List;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-lotto
 * create date  : 2019-06-22 01:29
 */
public class SplitUtils {

    public static List<String> commonSplit(String inputData) {
        return Arrays.asList(inputData.split(",|:"));
    }
}
