package step1;

import java.util.Arrays;
import java.util.Objects;

public class StringAddCalculator {
    private static final int INIT_NUMBER = 0;
    private static final int ZERO = 0;

    public static int splitAndSum(String text) {
        if (isNullOrEmpty(text)) {
            return ZERO;
        }
        return addSum(StringSplitter.splitStringByDelimiter(text));
    }

    private static boolean isNullOrEmpty(String text) {
        return Objects.isNull(text) || text.trim().isEmpty();
    }

    private static int convertStringToInteger(String test){
        int number = Integer.parseInt(test);
        if(number<ZERO){
            throw new RuntimeException("음수값은 입력이 불가능 합니다.");
        }
        return number;
    }

    private static int addSum(String[] stringNumbers){
        return Arrays.stream(stringNumbers)
                .mapToInt(StringAddCalculator::convertStringToInteger)
                .reduce(INIT_NUMBER,Integer::sum);
    }
}
