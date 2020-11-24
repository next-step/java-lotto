package lotto.domain;

import lotto.constant.ErrorMessage;
import lotto.constant.Lotto;
import lotto.constant.Rank;
import lotto.utils.IntegerUtils;
import lotto.utils.StringUtils;

import java.util.List;

public class WinningNumber {

    private final List<Integer> value;

    public WinningNumber(String winningNumbers) {
        List<Integer> numbers = convertStringToInteger(winningNumbers);
        valid(numbers);
        validDuplicate(numbers);
        value = numbers;
    }

    private List<Integer> convertStringToInteger(String winningNumbers) {
        List<String> strings = StringUtils.splitString(winningNumbers);
        return IntegerUtils.parsePositiveInt(strings);
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

    private void validDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != Lotto.NUMBER_RANGE) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ALLOW_DUPLICATED);
        }
    }


    public List<Integer> getValue() {
        return value;
    }

    public Rank getRank(LottoNumbers lottoNumbers) {
        return Rank.value(getMatchingNumberCount(lottoNumbers.getValue()));
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
