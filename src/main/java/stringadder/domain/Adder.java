package stringadder.domain;


import java.util.List;
import java.util.stream.Collectors;
import stringadder.utils.exception.InputValidException;

public class Adder {

    private static final String SPACE_DELIMITER = " ";
    private static final String BLANK_DELIMITER = "";
    private static final String NULL = null;

    public static int add(List<String> numbers) {

        if (numbers.contains(SPACE_DELIMITER) || numbers.contains(BLANK_DELIMITER)
            || numbers.contains(NULL)) {
            return 0;
        }

        List<Integer> convertInt = convertIntValue(numbers);
        checkInvalidValue(convertInt);

        return makeSum(convertInt);
    }

    private static int makeSum(List<Integer> convertInt) {
        return convertInt
            .stream()
            .mapToInt(Integer::intValue)
            .sum();
    }

    private static void checkInvalidValue(List<Integer> convertInt) {
        convertInt
            .stream()
            .peek(InputValidException::inputNegativeValidation)
            .collect(Collectors.toList());
    }

    private static List<Integer> convertIntValue(List<String> numbers) {
        return numbers.stream()
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }
}
