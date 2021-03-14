import util.Tokenizer;
import util.Validator;

import java.util.Arrays;

public class StringAddCalculator {
    public int splitAndSum(String parameter) {
        Tokenizer tokenizer = new Tokenizer(parameter);
        Validator validator = new Validator();

        if (!validator.isNotNullAndNotEmptyString(parameter)) {
            return 0;
        }

        String[] numbers = tokenizer.generateNumbers();
        if (validator.containsMinusNumbers(numbers)) {
            throw new RuntimeException();
        }
        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
