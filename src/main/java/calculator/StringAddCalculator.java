package calculator;

public class StringAddCalculator {

    public int add(String str) {
        if(isValidString(str)){
            return 0;
        }
        return 0;
    }

    public boolean isValidString(String validString){
        return !(validString == null || validString.length() == 0);

    }

}
