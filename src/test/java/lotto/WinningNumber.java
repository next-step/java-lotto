package lotto;

import java.util.List;

public class WinningNumber {

    private final List<Integer> value;

    public WinningNumber(String winningNumbers) {
        List<String> strings = StringUtils.splitString(winningNumbers);
        List<Integer> numbers = IntegerUtils.parsePositiveInt(strings);
        valid(numbers);
        value = numbers;
    }

    private void valid(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_ERROR);
        }

        for (Integer number : numbers) {
            validNumber(number);
        }
    }

    private void validNumber(Integer number) {
        if (number < 0 || number > 45) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_ERROR);
        }
    }

    public List<Integer> getValue() {
        return value;
    }

    public Rank getRank(List<Integer> numbers) {
        return Rank.value(getMatchingNumberCount(numbers));
    }

    private int getMatchingNumberCount(List<Integer> numbers) {
        int matchingNumberCount = 0;
        for (Integer integer : value) {
            matchingNumberCount += isExists(numbers, integer);
        }
        return matchingNumberCount;
    }

    private int isExists(List<Integer> numbers, int winningNumber) {
        if (numbers.contains(winningNumber)) {
            return 1;
        }
        return 0;
    }


}
