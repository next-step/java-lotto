package lotto.domain;

import lotto.constant.ErrorMessage;
import lotto.constant.Lotto;
import lotto.constant.Rank;
import lotto.utils.IntegerUtils;
import lotto.utils.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbers {

    private final List<LottoNumber> value;

    public WinningNumbers(String winningNumbers) {
        List<LottoNumber> numbers = convertStringToInteger(winningNumbers);
        valid(numbers);
        validDuplicate(numbers);
        value = numbers;
    }

    private List<LottoNumber> convertStringToInteger(String winningNumbers) {
        List<String> strings = StringUtils.splitString(winningNumbers);
        return IntegerUtils.parsePositiveInt(strings).stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    private void valid(List<LottoNumber> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_ERROR);
        }

        for (LottoNumber number : numbers) {
            validNumber(number);
        }
    }

    private void validNumber(LottoNumber number) {
        if (number.getValue() < 0 || number.getValue() > 45) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_ERROR);
        }
    }

    private void validDuplicate(List<LottoNumber> numbers) {
        if (numbers.stream().map(LottoNumber::getValue).distinct().count() != Lotto.NUMBER_RANGE) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ALLOW_DUPLICATED);
        }
    }


    public List<LottoNumber> getValue() {
        return value;
    }

    public Rank getRank(LottoNumbers lottoNumbers) {
        return Rank.value(getMatchingNumberCount(lottoNumbers));
    }

    private int getMatchingNumberCount(LottoNumbers numbers) {
        List<Integer> lottoNumbers = numbers.getIntegerValues();
        return (int) value.stream()
                .filter(lottoNumber -> isExists(lottoNumbers, lottoNumber))
                .count();

    }

    private boolean isExists(List<Integer> numbers, LottoNumber winningNumber) {
        if (numbers.contains(winningNumber.getValue())) {
            return true;
        }
        return false;
    }


}
