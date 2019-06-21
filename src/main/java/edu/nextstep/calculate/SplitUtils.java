package edu.nextstep.calculate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    private static final String REGEX_CUSTOM_SPLIT = "//(.)\n(.*)";
    private static final int CUSTOM_SPLIT_FRIST_GROUP = 1;
    private static final int CUSTOM_SPLIT_SECOND_GROUP = 2;

    public static List<String> commonSplit(String inputData) {
        return Arrays.asList(inputData.split(",|:"));
    }

    public static List<String> customSplit(String inputData) {
        Matcher m = Pattern.compile(REGEX_CUSTOM_SPLIT).matcher(inputData);
        List<String> customerSplit = new ArrayList<>();

        if (m.find()) {
            String customDelimiter = m.group(CUSTOM_SPLIT_FRIST_GROUP);
            String[] tokens = m.group(CUSTOM_SPLIT_SECOND_GROUP).split(customDelimiter);
            customerSplit = new ArrayList<>(Arrays.asList(tokens));
        }

        return customerSplit;
    }
}
