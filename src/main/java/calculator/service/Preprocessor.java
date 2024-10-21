package calculator.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Preprocessor {

    private static final Pattern CALCULATOR_PATTERN = Pattern.compile("\\d+|[+\\-*/]");

    public List<String> process(String calculationFormula) {

        boolean isVerification = verificationOfInputValue(calculationFormula);
        if(!isVerification) {
            return Collections.emptyList();
        }
        return valueSeparation(calculationFormula);
    }

    public boolean verificationOfInputValue(String calculationFormula) {
        calculationFormula = calculationFormula.trim();
        return !calculationFormula.isBlank();
    }

    private List<String> valueSeparation(String calculationFormula) {
        List<String> separatedValues = new ArrayList<>();

        Matcher matcher = CALCULATOR_PATTERN.matcher(calculationFormula);
        while(matcher.find()) {
            separatedValues.add(matcher.group());
        }

        return separatedValues;

    }

}
