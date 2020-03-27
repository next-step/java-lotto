package stringpluscalculator;

public class StringPlusCalculator {

    private static final int RETURN_VALUE_WHEN_EMPTY = 0;

    private String input;
    private Formula formula;

    public StringPlusCalculator(String input) {
        this.input = input;
    }

    public int calculate() {
        if(isEmpty(input)){
            return RETURN_VALUE_WHEN_EMPTY;
        }
        return 1;
    }

    private boolean isEmpty(String input){
        if(input == null || input.isEmpty()){
            return true;
        }
        return false;
    }
}
