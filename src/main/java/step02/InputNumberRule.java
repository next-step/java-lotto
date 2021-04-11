package step02;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static step02.LottoConfig.REGEX;

public class InputNumberRule extends NumberRule {
    List<Integer> inputNumber;

    public InputNumberRule(String inputNumber) {
        this.inputNumber = splitNumber(inputNumber);
    }

    @Override
    public List<Integer> makeNumbers() {
        return inputNumber;
    }

    private List<Integer> splitNumber(String numbers) {
       return Arrays.stream(numbers.trim().split(REGEX))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
