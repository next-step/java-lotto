package lotto.strategy;

import lotto.constant.LottoConstant;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Manual implements Numbers {
    private static final String DEFAULT_SPLIT_REGEX = ",";

    private final List<Integer> lottoNumber;

    public Manual(String numbers) {
        this.lottoNumber = createLottoNumber(numbers);
    }

    @Override
    public List<Integer> readOnlyNumbers() {
        return Collections.unmodifiableList(lottoNumber);
    }

    private List<Integer> createLottoNumber(String numbers) {
        List<Integer> result = stringToList(numbers).stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        isDuplicateNumbers(result);
        isLottoNumberCount(result);
        isWinnerNumbers(result);

        return result;
    }

    private void isLottoNumberCount(List<Integer> result) {
        if (result.size() != LOTTO_NUMBER_COUNT ) {
            throw new IllegalArgumentException(LottoConstant.LOTTO_NUMBER_COUNT_ERROR);
        };
    }

    private void isDuplicateNumbers(List<Integer> result) {
        int count = (int) result.stream()
                .distinct()
                .count();

        if (count != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(LottoConstant.LOTTO_NUMBER_DUPLICATE_ERROR);
        }
    }

    private void isWinnerNumbers(List<Integer> result) {
        if (result.stream()
                .anyMatch(this::isLottoNumberSize)) {
            throw new IllegalArgumentException(LottoConstant.LOTTO_NUMBER_SIZE_ERROR);
        };
    }

    private boolean isLottoNumberSize(int number) {
        return (MIN_NUMBER > number)
                || (MAX_NUMBER < number);
    }

    private List<String> stringToList(String winnerNumbers) {
        return Arrays.stream(winnerNumbers.split(DEFAULT_SPLIT_REGEX))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    @Override
    public boolean checkNumbers(List<Integer> numbers) {
        return Objects.equals(numbers, lottoNumber);
    }
}
