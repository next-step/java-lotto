package domain;

import java.util.regex.Pattern;

public class Calculate {

    private static final Pattern pattern = Pattern.compile("\\d");
    private int numberCache;
    private String operatorCache = "";

    public void process(String input){
        if(isNumber(input) && "".equals(operatorCache)){
            numberCache = toInts(input);
            return;
        }
        if(isNumber(input) && operatorCache.equals("+")){
            plus(toInts(input));
        }
        if(isNumber(input) && operatorCache.equals("-")){
            minus(toInts(input));
        }
        if(isNumber(input) && operatorCache.equals("*")){
            multiple(toInts(input));
        }
        if(isNumber(input) && operatorCache.equals("/")){
            divide(toInts(input));
        }
        operatorCache = input;
    }

    private int toInts(String input) {
        return Integer.parseInt(input);
    }

    public int getResult() {
        return numberCache;
    }

    private void minus(int number) {
        numberCache -= number;
    }

    private void plus(int number){
        numberCache += number;
    }

    private void multiple(int number){
        numberCache *= number;
    }

    private void divide(int number){
        numberCache /= number;
    }

    private static boolean isNumber(String str) {
        return pattern.matcher(str).find();
    }
}
