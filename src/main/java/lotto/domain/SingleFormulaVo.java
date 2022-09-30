package lotto.domain;

import java.util.regex.Pattern;

public class SingleFormulaVo {
    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]\\d*(\\.\\d+)?$");

    private Integer number;
    private String operator = "+";

    public SingleFormulaVo(){}
    public SingleFormulaVo(Integer number, String operator){
        this.number = number;
        this.operator = operator;
    }

    public boolean isValid(){
        return this.number != null && this.operator != null;
    }

    public void set(String string){
        if(isNumber(string)){
            this.number = Integer.parseInt(string);
            return;
        }

        if(isOperator(string)){
            this.operator = string;
            return;
        }

        throw new IllegalArgumentException("Wrong element");
    }

    public Integer getNumber() {
        return number;
    }

    public String getOperator() {
        return operator;
    }

    public void reset(){
        this.number = null;
        this.operator = null;
    }

    private static boolean isNumber(String string) {
        return NUMBER_PATTERN.matcher(string).find();
    }

    private static boolean isOperator(String string){
        return string != null && (string.equals("+") || string.equals("-") || string.equals("*") || string.equals("/"));
    }

}
