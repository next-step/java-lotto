package lotto.domain;

import lotto.constant.LottoConstant;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbers {
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final String DEFAULT_SPLIT_REGEX = ",";

    private static final List<Integer> LOTTO_NUMBERS = IntStream.range(MIN_NUMBER, MAX_NUMBER)
            .boxed()
            .collect(Collectors.toList());

    private final List<Integer> lottoNumber;

    public LottoNumbers() {
        this.lottoNumber = createLottoNumbers();
    }

    public LottoNumbers(List<Integer> lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    private List<Integer> createLottoNumbers() {
        List<Integer> numbers = LOTTO_NUMBERS;

        Collections.shuffle(numbers);

        List<Integer> result = numbers.stream()
                .limit(LOTTO_NUMBER_COUNT)
                .collect(Collectors.toList());

        Collections.sort(result);

        return result;
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

    private List<String> stringToList(String winnerNumbers) {
        return Arrays.stream(winnerNumbers.split(DEFAULT_SPLIT_REGEX))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    // 유효성 start.
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
    // 유효성 end.

    public List<Integer> readOnlyNumbers() {
        return Collections.unmodifiableList(lottoNumber);
    }

    public boolean checkNumbers(List<Integer> numbers) {
        return Objects.equals(numbers, lottoNumber);
    }
}
