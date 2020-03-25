import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringAddCalculator {
    public static int addString(String input){
        if(isNullOrEmpty(input)){
            return 0;
        }
        return sum(convertFromStringToNumbers(input));
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private static int sum(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    private static List<Integer> convertFromStringToNumbers(String input){
        List<String> strings = splitByDefault(input);
        return validateNegative(covertToNumber(strings));
    }

    private static List<String> splitByDefault(String input) {
        return Arrays.asList(input.split(",|:"));
    }

    private static List<Integer> covertToNumber(List<String> stringNumbers) {
        try {
            return stringNumbers.stream()
                    .map(stringNumber -> Integer.parseInt(stringNumber))
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자가 아닌 값은 입력할 수 없습니다.");
        }
    }

    private static List<Integer> validateNegative(List<Integer> numbers) {
        if (hasNegative(numbers)) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }
        return numbers;
    }

    private static boolean hasNegative(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number < 0)
                .findAny()
                .isPresent();
    }
}