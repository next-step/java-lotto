package lotto.domain;

import lotto.constant.LottoConstant;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final String DEFAULT_SPLIT_REGEX = ",";

    private static final List<Integer> LOTTO_NUMBERS = IntStream.range(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER)
                                                            .boxed()
                                                            .collect(Collectors.toList());

    private final List<Integer> lottoNumbers;

    public LottoNumber() {
        this.lottoNumbers = createLottoNumbers();
    }

    public LottoNumber(String stringNumber) {
        this.lottoNumbers = createLottoNumber(stringNumber);
    }

    public LottoNumber(List<Integer> winnerNumber) {
        this.lottoNumbers = winnerNumber;
    }

    private List<Integer> createLottoNumbers() {
        List<Integer> numbers = LOTTO_NUMBERS;

        Collections.shuffle(numbers);

        List<Integer> result = numbers.stream()
                .limit(LottoConstant.LOTTO_NUMBER_COUNT)
                .collect(Collectors.toList());

        Collections.sort(result);

        return result;
    }

    private List<Integer> createLottoNumber(String stringNumber) {
        List<Integer> result = stringToList(stringNumber).stream()
                                .map(Integer::parseInt)
                                .collect(Collectors.toList());

        isDuplicateNumbers(result);
        isLottoNumberCount(result);
        isWinnerNumbers(result);

        return result;
    }

    private void isLottoNumberCount(List<Integer> result) {
        if (result.size() != LottoConstant.LOTTO_NUMBER_COUNT ) {
            throw new IllegalArgumentException(LottoConstant.LOTTO_NUMBER_COUNT_ERROR);
        };
    }

    private void isDuplicateNumbers(List<Integer> result) {
        int count = (int) result.stream()
                .distinct()
                .count();

        if (count != LottoConstant.LOTTO_NUMBER_COUNT) {
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
        return (LOTTO_MIN_NUMBER > number)
                || (LOTTO_MAX_NUMBER < number);
    }

    private List<String> stringToList(String winnerNumbers) {
        return Arrays.stream(winnerNumbers.split(DEFAULT_SPLIT_REGEX))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public List<Integer> readOnlyWinnerNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    public boolean checkNumbers(List<Integer> numbers) {
        return Objects.equals(lottoNumbers, numbers);
    }
}
