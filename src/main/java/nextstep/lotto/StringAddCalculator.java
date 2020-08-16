package nextstep.lotto;

import nextstep.lotto.dto.InputNumber;
import nextstep.lotto.dto.NumberFactory;
import nextstep.lotto.utils.StringUtils;
import nextstep.lotto.utils.ValidationUtils;

import java.util.List;


public class StringAddCalculator {
    public static int splitAndSum(String inputValue) {
        if(ValidationUtils.isNullAndEmpty(inputValue)) {
            return 0;
        }

        return sumInArrayNumber(StringUtils.splitString(inputValue));
    }

    private static int sumInArrayNumber(String[] splitString){
        int sum = 0;
        List<InputNumber> inputNumbers = NumberFactory.create(splitString);

        for(InputNumber number : inputNumbers){
            sum += number.getNumber();
        }

        return sum;
    }
}
