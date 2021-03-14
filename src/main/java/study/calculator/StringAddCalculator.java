package study.calculator;

import java.util.List;

import static study.calculator.Validator.isNotNullAndIsBlank;
import static study.calculator.Validator.isSingleLengthAndIsNotNumeric;

public class StringAddCalculator {

    public static int splitAndSum(String text) {
        if(isNotNullAndIsBlank(text)) { // null 또는 ""
            return 0;
        }

        if(isSingleLengthAndIsNotNumeric(text)) {
            throw new RuntimeException("숫자로 캐스팅할 수 없는 문자입니다.");
        }

        Numbers numberManager = Numbers.of(text);
        List<Integer> numbers = numberManager.getNumbers();

        return numbers
                .stream()
                .reduce(Integer::sum)
                .get();
    }
}
