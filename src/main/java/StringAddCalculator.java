import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int splitAndSum(String input) {
        //input 검증
        if(StringUtils.isBlank(input)){
            return 0;
        }

        String[] tokens= getTokens(input);
        return add(tokens);
    }

    private static int add(String[] tokens) {
        int sum = 0;
        for (String token: tokens) {
            sum += convertInt(token);
        }
        return sum;
    }

    private static String[] getTokens(String input){

        //input 검증
        Matcher m2 = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m2.find()) {
            String customDelimiter = m2.group(1);
            return m2.group(2).split(customDelimiter);
        }

        //input 검증
        String pa = "([0-9 \\, \\: ])";
        if (Pattern.compile(pa).matcher(input).find())
            return input.split(",|:");
        return null;
    }

    //input 검증
    private static int convertInt(String input){
        int resunt = Integer.parseInt(input);
        if (resunt < 0) {
            throw new RuntimeException("음수는 지원하지 않습니다.");
        }
        return resunt;
    }
}
