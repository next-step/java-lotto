package step1;

import java.util.regex.Pattern;

public class StringPlusCalculator {

    private static final Pattern numberRegExp = Pattern.compile("^[0-9]+$");

    public int calculate(String factors) throws RuntimeException{

        Factor factor = new Factor();

        if(factors == null){
            return Constant.ZERO;
        }

        int result = Constant.ZERO;
        for(String number : factor.parseNumbers(factors)){
            checkMinusFactor(number);
            result = result + Integer.parseInt(number);
        }

        return result;
    }

    private void checkMinusFactor(String factor){
        if(factor.contains("-") || !(numberRegExp.matcher(factor).find())){
            throw new RuntimeException();
        }
    }
}
