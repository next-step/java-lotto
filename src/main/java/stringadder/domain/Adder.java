package stringadder.domain;


import java.util.List;
import java.util.stream.Collectors;
import stringadder.utils.exception.InputValidException;

public class Adder {

    private static final String BLANK = " ";
    private static final String EMPTY_SPACE = "";
    private static final String NULL = null;
    private static final int VALIDATE_NUMBER_TRUE = 0;
    private static final int VALIDATE_NUMBER_FALSE = -1;

    public static int add(List<String> numbers) {

        int x = validateNumber(numbers);
        if (x != VALIDATE_NUMBER_FALSE) {
            return x;
        }

        List<Integer> convertInt = ConvertInt.convertInt(numbers);
        validateNegativeNumber(ConvertInt.convertInt(numbers));

        return convertInt.stream()
            .mapToInt(Integer::intValue)
            .sum();
    }

    private static void validateNegativeNumber(List<Integer> convertInt) {
        convertInt.stream()
            .peek(InputValidException::inputNegativeValidation)
            .collect(Collectors.toList());
    }

    private static int validateNumber(List<String> numbers) {
        if (numbers.contains(BLANK) ||
            numbers.contains(EMPTY_SPACE) ||
            numbers.contains(NULL)) {
            return VALIDATE_NUMBER_TRUE;
        }
        return VALIDATE_NUMBER_FALSE;
    }
}
