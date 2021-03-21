package step1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Split {
    private final static String DELIMITER = ",|:";
    private final static String REG_DELIMITER = "//(.)\n(.*)";



    public static String[] split(String inputString){
        if(inputString == null){
            return new String[]{"0"};
        }
        if(inputString.isEmpty()){
            return new String[]{"0"};
        }
        return splitDelimiter(inputString);
    }

    private static String[] splitDelimiter(String inputString){
        Matcher m = Pattern.compile(REG_DELIMITER).matcher(inputString);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens= m.group(2).split(customDelimiter);
            return tokens;
        }
        return inputString.split(DELIMITER);
    }
}
