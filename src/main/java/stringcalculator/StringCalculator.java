package stringcalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    final static int ZERO=0;

    public int calculator(String str) {
        int result;

        str = emptyOrNull(str);

        result = sum(getDelimiter(str));

        return result;
    }

    private String emptyOrNull(String str) {
        if (str == null || str == "") {
            str = "0";
        }
        return str;
    }

    public List getDelimiter(String str) {

        List<Integer> strcharList = new ArrayList<>();
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(str);
        String Delimiter;
        if (m.find()) {
            Delimiter = m.group(1);
            str = m.group(2).replaceAll(",|:", "");
        } else {
            Delimiter = "[,:]";
        }
        splitMethod(str, strcharList, Delimiter);
        return strcharList;
    }

    public void splitMethod(String str, List<Integer> strcharList, String Delimiter) {
        for (String element : str.split(Delimiter)) {
            minusThrowException(element);
            strcharList.add(Integer.valueOf(element));
        }
    }

    public void minusThrowException(String c) {
        if (Integer.valueOf(c) < ZERO) throw new RuntimeException("음수불가");
    }


    public int sum(List<Integer> strcharList) {
        return strcharList.stream().reduce((a, b) -> Integer.sum(a, b)).get();
    }
}
