package stringcalculator.util;

import java.util.ArrayList;
import java.util.List;
import stringcalculator.domain.Validator;

public class Converter {

    public static List<Integer> convertOperandType(List<String> tokens) {
        List<Integer> numbers = new ArrayList<>();
        tokens.forEach(
            token -> {
                int intToken = Validator.validateTypeOfToken(token);
                numbers.add(Validator.validatePositiveNumber(intToken));
            }
        );
        return numbers;
    }
}
