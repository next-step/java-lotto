package step2.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class LottoWinningNumber {
    private List<Integer> winningNumber;

    public LottoWinningNumber(String winningNumber) {
        this.winningNumber = splitNumber(winningNumber);
    }

    public List<Integer> splitNumber(String inputNumber) {
        if (isNullOrEmpty(inputNumber)) {
            throw new IllegalArgumentException(LottoConstant.VALID_WINNINT_NUMBER_NULL_MESSAGE);
        }
        return putListWinningNumber(removeBlank(inputNumber).split(LottoConstant.SPLIT_SEPERATOR));
    }

    private List<Integer> putListWinningNumber(String[] splitNumbers) {
        if (!isNumeric(splitNumbers)) {
            throw new IllegalArgumentException(LottoConstant.VALID_WINNING_NUMBER_MESSAGE);
        }

        int[] intSplitNumbers = Stream.of(splitNumbers)
                .mapToInt(Integer::parseInt)
                .toArray();

        return addWinningNumberList(intSplitNumbers);
    }

    private List<Integer> addWinningNumberList(int[] intSplitNumbers) {
        List<Integer> inputWinningNumbers = new ArrayList<>();

        for (int number : intSplitNumbers) {
            inputWinningNumbers.add(number);
        }

        return validateDuplicationCheck(inputWinningNumbers);
    }

    public List<Integer> validateDuplicationCheck(List<Integer> numbers) {
        Set<Integer> checkList = new HashSet<>(numbers);
        if (numbers.size() != checkList.size()) {
            throw new IllegalArgumentException(LottoConstant.VALID_LOTTO_NUMBER_DUPLICATE_MESSAGE);
        }
        return numbers;
    }

    private String removeBlank(String inputString) {
        return inputString.replaceAll("\\p{Z}", "");
    }

    private boolean isNumeric(String[] splitNumber) {
        boolean isNumeric = true;

        for (String number : splitNumber) {
            isNumeric = isNumeric && numericCheck(number);
        }
        return isNumeric;
    }

    private boolean numericCheck(String number) {
        return Pattern.matches("^[0-9]*$", number);
    }

    private boolean isNullOrEmpty(String inputString) {
        return inputString == null || inputString.isEmpty();
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }
}
