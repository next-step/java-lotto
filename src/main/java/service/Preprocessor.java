package service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Preprocessor {

    private final Pattern compile = Pattern.compile("\\d+|[+\\-*/]");

    public List<String> process(String calculationFormula) {

        List<String> values = new ArrayList<>();

        boolean isVerification = verificationOfInputValue(calculationFormula);
        if(!isVerification) {
            return values;
        }

        return valueSeparation(calculationFormula);
    }

    public boolean verificationOfInputValue(String calculationFormula) {

        calculationFormula = calculationFormula.trim();
        if(calculationFormula.isBlank()) {
            return false;
        }
        return true;
    }


    private List<String> valueSeparation(String calculationFormula) {
        List<String> separatedValues = new ArrayList<>();

        Matcher matcher = compile.matcher(calculationFormula);
        while(matcher.find()) {
            separatedValues.add(matcher.group());
        }

        return separatedValues;

    }

}
