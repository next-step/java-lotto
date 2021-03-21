package step1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public StringAddCalculator(){

    }

    public static int splitAndSum(String inputString){
        String[] splitStrings = Split.split(inputString);
        Integer[] parseNumbers = Parser.parser(splitStrings);
        int result = Calculator.add(parseNumbers);
        return result;
    }
}
