package step1.addCalculator.domain;

import step1.addCalculator.util.CommonValueCheck;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



/**
 * inputText의 값을 컨트롤하는 객체
 */
public class InputTextProcessing {

    private static final Pattern CUSTOM_STRING_LIST = Pattern.compile("//(.)\n(.*)");
    private static String inputText;
    private static String splitValue = ",|:";

    public InputTextProcessing(String inputText) {
        this.inputText = inputText;
    }

    public List<Integer> runProcessing() {
        return changeStrToIntList();
    }

    public boolean isNullOrEmptyCheck() {
        if (inputText == null || "".isEmpty()) {
            return false;
        }

        return true;
    }

    private List<Integer> changeStrToIntList() {
        Matcher m = CUSTOM_STRING_LIST.matcher(inputText);

        if (m.find()) {
            splitValue = m.group(1);
            return changeStrToInt(makeStringArr(m.group(2)));
        }

        return changeStrToInt(makeStringArr(inputText));
    }

    private List<String> makeStringArr(String paramValue) {
        String[] returnArr = paramValue.split(splitValue);
        return Arrays.asList(returnArr);
    }

    private List<Integer> changeStrToInt(List<String> paramList) {
        List<Integer> returnList = new ArrayList<>();

        for (String str : paramList) {
            returnList.add(CommonValueCheck.valueCheck(str));
        }

        return returnList;
    }
}
