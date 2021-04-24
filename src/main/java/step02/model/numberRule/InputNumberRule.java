package step02.model.numberRule;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static step02.utils.LottoConfig.*;

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
        String numbersNoBlank = numbers.replaceAll(BLANK, NO_BLANK);
        List<Integer> numberSplit = Arrays.stream(numbersNoBlank.trim().split(REGEX))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        if (checkNumbersUnique(numberSplit)) {
            return numberSplit;
        }
        throw new IllegalArgumentException(ERROR_INPUT_WINNER_NUMBER);
    }

    private boolean checkNumbersUnique(List<Integer> numberSplit) {
        if (numberSplit.stream().allMatch(new HashSet<>()::add)) {
            return checkNumberCountIsSix(numberSplit.size());
        }
       return false;
    }

    private boolean checkNumberCountIsSix(int listSize) {
        return listSize == 6;
    }


}
