package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumber {
    private final List<Integer> numbers;
    private final int bonusNumber;

    public WinningNumber(String numberInput, String bonusNumberInput) {
        List<Integer> inputNumbers = fromNumberInput(numberInput);
        int bonusNumber = fromBonusNumberInput(bonusNumberInput);
        validate(inputNumbers, bonusNumber);
        this.numbers = inputNumbers;
        this.bonusNumber = bonusNumber;
    }

    public boolean containsNumbers(int lottoNumber) {
        return numbers.contains(lottoNumber);
    }

    public boolean matchBonusNumber(int lottoNumber) {
        return bonusNumber == lottoNumber;
    }

    private List<Integer> fromNumberInput(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private int fromBonusNumberInput(String bonusNumberInput) {
        return Integer.parseInt(bonusNumberInput);
    }

    private void validate(List<Integer> numbers, int bonusNumber) {
        validateDuplicateNumbers(numbers);
        validateBonusNumber(numbers, bonusNumber);
    }

    private void validateBonusNumber(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨번호와 중복될 수 없습니다.");
        }
    }

    private static void validateDuplicateNumbers(List<Integer> numbers) {
        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        if (distinctNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("당첨번호는 중복될 수 없습니다.");
        }
    }
}
