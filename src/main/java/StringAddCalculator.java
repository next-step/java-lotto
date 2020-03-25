import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringAddCalculator {
    public static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    public static List<String> splitByDefault(String input) {
        return Arrays.asList(input.split(",|:"));
    }

    public static List<Integer> covertToNumber(List<String> stringNumbers) {
        try {
            return stringNumbers.stream()
                    .map(stringNumber -> Integer.parseInt(stringNumber))
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자가 아닌 값은 입력할 수 없습니다.");
        }
    }

    public static void validateNegative(List<Integer> numbers) {
        boolean hasNegative = numbers.stream()
                .filter(number -> number < 0)
                .findAny()
                .isPresent();
        if(hasNegative){
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }
    }
}
