package lotto.domain;

import lotto.constant.ErrorMessage;
import lotto.constant.Lotto;
import lotto.constant.Rank;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {

    private static final String DEFAULT_SEPARATOR = ",";
    private static final String BLANK = " ";
    private static final String DELETE_BLANK = "";
    private final List<LottoNumber> value;

    public LottoNumbers(String winningNumbers) {
        validEmpty(winningNumbers);
        List<LottoNumber> numbers = convertStringToInteger(winningNumbers);
        value = numbers;
    }

    public LottoNumbers(List<LottoNumber> value) {
        this.value = value;
    }

    public List<LottoNumber> getValue() {
        return value;
    }

    public List<Integer> getIntegerValues() {
        return value.stream().map(LottoNumber::getValue).collect(Collectors.toList());
    }

    private List<LottoNumber> convertStringToInteger(String winningNumbers) {

        List<String> strings = splitString(winningNumbers);

        List<LottoNumber> numbers = parsePositiveInt(strings).stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        valid(numbers);

        return numbers;
    }


    public Rank getRank(LottoNumbers lottoNumbers) {
        return Rank.value(getMatchingNumberCount(lottoNumbers));
    }

    private int getMatchingNumberCount(LottoNumbers numbers) {
        List<Integer> lottoNumbers = numbers.getIntegerValues();
        return (int) value.stream()
                .filter(lottoNumber -> lottoNumbers.contains(lottoNumber.getValue()))
                .count();

    }

    public List<String> splitString(String value) {
        return Arrays.asList(value.replace(BLANK, DELETE_BLANK).split(DEFAULT_SEPARATOR));
    }

    private void validNumber(LottoNumber number) {
        if (number.getValue() < 0 || number.getValue() > 45) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_ERROR);
        }
    }

    private void valid(List<LottoNumber> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_ERROR);
        }

        for (LottoNumber number : numbers) {
            validNumber(number);
        }

        if (numbers.stream().map(LottoNumber::getValue).distinct().count() != Lotto.NUMBER_RANGE) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ALLOW_DUPLICATED);
        }
    }

    private void validEmpty(String value) {
        if (value == null || value.isEmpty() || value.equals(" ")) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_ERROR);
        }
    }

    public List<Integer> parsePositiveInt(List<String> values) {
        return values.stream()
                .map(Integer::parseInt)
                .map(this::validPositive)
                .collect(Collectors.toList());
    }

    private Integer validPositive(Integer value) {
        if (value < 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ALLOW_NEGATIVE_QUANTITY);
        }
        return value;
    }
}
