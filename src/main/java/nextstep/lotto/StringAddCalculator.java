package nextstep.lotto;

import nextstep.lotto.utils.IntegerUtils;
import nextstep.lotto.utils.StringUtils;
import nextstep.lotto.utils.ValidationUtils;


public class StringAddCalculator {
    public static int splitAndSum(String inputValue) {
        if(ValidationUtils.isNullAndEmpty(inputValue)) {
            return 0;
        }

        return sumInArrayNumber(StringUtils.splitString(inputValue));
    }

    private static int sumInArrayNumber(String[] splitString){
        int sum = 0;

        for(String targetString : splitString){
            sum += IntegerUtils.parsePositiveInt(targetString);
        }

        return sum;
    }
}
