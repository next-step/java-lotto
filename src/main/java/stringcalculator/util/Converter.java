package stringcalculator.util;

import static stringcalculator.domain.Validator.validatePositiveNumber;

import java.util.ArrayList;
import java.util.List;

public class Converter {

    public static List<Integer> convertOperandType(List<String> tokens) {
        List<Integer> numbers = new ArrayList<>();
        tokens.forEach(
            token -> numbers.add(validatePositiveNumber(token))
        );
        return numbers;
    }
}
