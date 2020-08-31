package step1;

import java.util.regex.Pattern;

public class Factor {

    private static final Pattern customSeparatorRegExp = Pattern.compile("//");

    public String[] parseNumbers(String numbers){

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

    public boolean isCustomSeparatorUsed(String numbers){
        return customSeparatorRegExp.matcher(numbers).find();
    }

    public String parseCustomSeparator(String numbers){
        return String.valueOf(numbers.charAt(Constant.CUMSTOM_SEPARATOR_INDEX));
    }

}
