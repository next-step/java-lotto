package step1;

import java.util.regex.Pattern;

public class StringPlusCalculator {

    private static final Pattern customSeparatorRegExp = Pattern.compile("//");
    private static final Pattern numberRegExp = Pattern.compile("^[0-9]+$");

    String[] parseNumbers(String numbers){

        String[] factors;
        String separator = ",|:";

        if(numbers.isEmpty()){
            return new String[]{"0"};
        }

        if(isCustomSeparatorUsed(numbers)){
            separator = parseCustomSeparator(numbers);
            numbers = numbers.substring(Constant.CUMSTOM_SEPARATOR_FACTOR_START_INDEX);
        }

        factors = numbers.split(separator);
        return factors;
    }

    boolean isCustomSeparatorUsed(String numbers){
        return customSeparatorRegExp.matcher(numbers).find();
    }

    String parseCustomSeparator(String numbers){
        return String.valueOf(numbers.charAt(Constant.CUMSTOM_SEPARATOR_INDEX));
    }

    int calculate(String factors) throws RuntimeException{
        if(factors == null){
            return Constant.ZERO;
        }

        int result = Constant.ZERO;
        for(String factor : parseNumbers(factors)){
            checkMinusFactor(factor);
            result = result + Integer.parseInt(factor);
        }

        return result;
    }

    private void checkMinusFactor(String factor){
        if(factor.contains("-") || !(numberRegExp.matcher(factor).find())){
            throw new RuntimeException();
        }
    }
}
