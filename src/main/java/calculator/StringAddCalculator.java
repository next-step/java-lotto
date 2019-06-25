package calculator;

import java.util.Arrays;

public class StringAddCalculator {

    public int add(String str) {
        if(isValidString(str)){
            return 0;
        }

        String[] splitedStr = Splitter.split(str);
        return sum(splitedStr);
    }

    public boolean isValidString(String validString){
        return !(validString == null || validString.length() == 0);

    }

    public static int sum(String[] strings){
        return Arrays.stream(strings)
                .mapToInt(Integer::parseUnsignedInt)
                .sum();
    }
}
