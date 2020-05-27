package lotto_step1;

import spark.utils.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSplit {

    public static String checkCustomSeparator(String inputValue) {
        Matcher matcher = Pattern.compile("[//(.)\n(.*)]").matcher(inputValue.trim());

        if (matcher.find()) {
            return inputValue.substring(CalculatorConstants.START_POINT, CalculatorConstants.END_POINT);
        }
        return "";
    }

    public static List<String> splitInputValue(String inputValue, String separator) {
        isBlank(inputValue);

        if (StringUtils.isBlank(separator)) {
            return Arrays.asList(inputValue.split("[,|:]"));
        }
        return Arrays.asList(inputValue.substring(CalculatorConstants.NUMBER_START_POINT).split(separator));
    }

    public static void checkSplitValues(List<String> splitValues) {
        for (String splitValue : splitValues) {
            isNumber(splitValue);
            isNegative(splitValue);
        }
    }

    public static void isBlank(String inputValue) {
        if (StringUtils.isBlank(inputValue)) {
            throw new IllegalArgumentException("입력값 NULL이거나 공백");
        }
    }

    public static void isNegative(String inputValue) {
        if(Integer.parseInt(inputValue) < 0){
            throw new IllegalArgumentException("입력값 음수");
        }
    }

    public static void isNumber(String inputValue) {
        String regExp = "^[0-9]+$";

        if(!inputValue.matches(regExp)){
            throw new IllegalArgumentException("입력값 숫자아님");
        }
    }
}

