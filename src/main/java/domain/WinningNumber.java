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
        validate(inputNumbers);
        this.numbers = inputNumbers;
        this.bonusNumber = bonusNumber;
    }

    public boolean contains(int lottoNumber) {
        return numbers.contains(lottoNumber);
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

    private void validate(List<Integer> numbers) {
        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        if (distinctNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("당첨번호는 중복될 수 없습니다.");
        }
    }
}
