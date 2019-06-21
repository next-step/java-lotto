package edu.nextstep.calculate;

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
    private static final String SPACE_FORMAT_DEFAULT_SUM_NUMBER = "0";
    private static final int CUSTOM_SPLIT_FRIST_GROUP = 1;
    private static final int CUSTOM_SPLIT_SECOND_GROUP = 2;

    public static List<String> inputDataSplit(String inputData) {
        if(isSpace(inputData)) {
            return Arrays.asList(SPACE_FORMAT_DEFAULT_SUM_NUMBER);
        }

        Matcher m = Pattern.compile(REGEX_CUSTOM_SPLIT).matcher(inputData);

        if (m.find()) {
            String customDelimiter = m.group(CUSTOM_SPLIT_FRIST_GROUP);
            String[] tokens = m.group(CUSTOM_SPLIT_SECOND_GROUP).split(customDelimiter);

            return Arrays.asList(tokens);
        }

        return commonSplit(inputData);
    }

    public static List<String> commonSplit(String inputData) {
        return Arrays.asList(inputData.split(",|:"));
    }

    public static boolean isSpace(String inputData) {
        return ("".equals(inputData) || inputData == null);
    }
}
