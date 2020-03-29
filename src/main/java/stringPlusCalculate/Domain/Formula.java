package stringPlusCalculate.Domain;


import stringPlusCalculate.Constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Formula {

    String formula;

    private Formula(String formula) {
        this.formula = formula;
    }

    public static Formula init(String formula) {
        return new Formula(formula);
    }

    public ArithmeticTargets arithmeticBySplit() {
        if(formula.trim().isEmpty()) {
            return ArithmeticTargets.empty();
        }


        List<String> arithmetic = filtArithmetic();
        stringAndNegativeNumberException(arithmetic);

        return ArithmeticTargets.createByStringList(arithmetic);
    }

    private void stringAndNegativeNumberException(List<String> arithmetic) {
        for(String arithmeticTarget : arithmetic) {
            IsStringAndNegativeNumber(arithmeticTarget);
        }
    }

    private void IsStringAndNegativeNumber(String arithmeticTarget) {
        if(Integer.parseInt(arithmeticTarget) < 0) {
            throw new RuntimeException();
        }

        try {
            Integer.parseInt(arithmeticTarget);
        } catch (Exception e) {
            throw  new RuntimeException();
        }
    }

    List<String> filtArithmetic() {

        List<String> splitters = determineSplitter();
        String trimArithmetic = trimArithmetic(splitters);
        return new ArrayList<>(Arrays.asList(trimArithmetic.split(Constants.EMPTY_STRING)));
    }

    List<String> determineSplitter() {
        if(isSplitter()) {
            List<String> splitters = new ArrayList<>();
            splitters.add(findSplitter());
            return splitters;
        }

        return Arrays.asList(":", ",");
    }

    boolean isSplitter() {
        return formula.matches(Constants.SPLITTER_EXISTENCE_REGEX);
    }

    String findSplitter() {
        int splitterStart = formula.indexOf(Constants.SPLITTER_DIVIDER_START) + Constants.SPLITTER_DIVIDER_START.length();
        int splitterEnd = formula.indexOf(Constants.SPLITTER_DIVIDER_END);

        return formula.substring(splitterStart, splitterEnd);
    }

    String trimArithmetic(List<String> splitters) {

        String pureArithmetic = targetArithmetic(formula);

        for (String splitter : splitters) {
            pureArithmetic = pureArithmetic.replace(splitter, "");
        }
        return pureArithmetic;
    }

    String targetArithmetic(String formula) {
        if(isSplitter()) {
            return formula.substring(formula.indexOf(Constants.SPLITTER_DIVIDER_END) + Constants.SPLITTER_DIVIDER_END.length());
        }
        return formula;
    }



    @Override
    public String toString() {
        return formula;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return this.toString().equals(((Formula) obj).toString());
    }
}
