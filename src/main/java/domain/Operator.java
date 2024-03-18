package domain;

import java.util.regex.Matcher;

public enum Operator {

    PLUS("+"),
    MINUS("-"),
    MULTIPLE("*"),
    DIVIDE("/"),
    
    ;
    private final String operator;

    Operator(String operator) {
        this.operator = operator;
    }

    public static boolean isOperator(String input){
        return PLUS.operator.equals(input) || MINUS.operator.equals(input) || MULTIPLE.operator.equals(input) || DIVIDE.operator.equals(input);
    }
}
