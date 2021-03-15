import util.Tokenizer;
import util.Validator;

import java.util.Arrays;

public class StringAddCalculator {
    String[] numbers;
    public int calculate(String parameter) {
        Validator validator = new Validator();

        if (!validator.isNotNullAndNotEmptyString(parameter)) {
            return 0;
        }
        splitParameter(parameter);

        if (validator.containsMinusNumbers(numbers)) {
            throw new RuntimeException("음의 정수는 포함될 수 없습니다.");
        }

        return getSum();
    }

    /**
     * 쪼개서 배열생성.
     * @param parameter
     */
    private void splitParameter(String parameter) {
        Tokenizer tokenizer = new Tokenizer(parameter);
        numbers = tokenizer.generateNumbers();
    }

    /**
     * 숫자배열의 합을 구한다.
     * @return
     */
    private int getSum() {
        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
