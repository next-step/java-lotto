package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParserUtils {

    public boolean checkEmpty(String input) {

        if (input.isEmpty()) {
            return false;
        }
        return true;
    }

    public boolean checkNull(String input) {

        if (input == null) {
            return false;
        }
        return true;
    }

    public List stringToArray(String input) {


        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
        if(matcher.find()){
            String customDelimiter = matcher.group(1);
            return stringListToIntList(matcher.group(2).split(customDelimiter));
        }

        String[] splitText = input.split(",|:");
        return stringListToIntList(splitText);
    }

    private List stringListToIntList(String[] splitText){
        List resultList = new ArrayList();
        for (String text:splitText) {
            resultList.add(Integer.parseInt(text));
        }

        return resultList;
    }
}
