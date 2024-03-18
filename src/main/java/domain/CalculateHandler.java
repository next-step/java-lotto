package domain;

import static util.NumberUtils.isNumber;

public class CalculateHandler {

    private int numberCache;
    private Operator operatorCache;
    private String previousState = "";

    public void handle(String input){
        if(isNumber(input) && "".equals(previousState)){
            numberCache = toInts(input);
            previousState = input;
            return;
        }
        if(isNumber(input)){
            validateIfDuplication(input);
            numberCache = operatorCache.apply(numberCache, toInts(input));
            previousState = input;
            return;
        }
        validateIfDuplication(input);
        operatorCache = Operator.toOperator(input);
        previousState = input;
    }

    private void validateIfDuplication(String input) {
        if(isNumber(input) && isNumber(previousState)) throw new IllegalArgumentException();
        if(!isNumber(input) && !isNumber(previousState)) throw new IllegalArgumentException();
    }

    private int toInts(String input) {
        return Integer.parseInt(input);
    }
    
    public int getResult(){
        return this.numberCache;
    }
}
