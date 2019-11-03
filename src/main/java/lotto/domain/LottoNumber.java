package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoNumber {

    public static final String GRATER_THAN_NUMBER_COUNT_ERROR = "입력된 번호의 개수가 너무 많습니다. 6개의 번호를 입력해주세요.";
    public static final String LESS_THAN_NUMBER_COUNT_ERROR = "입력된 번호의 개수가 너무 적습니다. 6개의 번호를 입력해주세요.";
    public static final String DUPLICATED_NUMBER_ERROR = "로또 번호는 중복될 수 없습니다.";
    public static final String INVALID_RANGE_NUMBER_ERROR = "로또 번호는 1 ~ 45 사이의 숫자만 입력가능합니다.";
    private static final int LOTTO_NUMBER_SIZE = 6;
    static final int MAX_NUMBER = 45;
    static final int MIN_NUMBER = 1;

    private final List<Integer> numbers;

    public LottoNumber() {
        this.numbers = getShuffledNumbers();
    }

    public LottoNumber(List<Integer> numbers) {
        assertValidNumbers(numbers);
        this.numbers = numbers;
    }

    private List<Integer> getShuffledNumbers() {
        List<Integer> numberCandidates = LottoNumberPool.getNumbers();

        Collections.shuffle(numberCandidates);

        return numberCandidates.stream().limit(LOTTO_NUMBER_SIZE).sorted().collect(Collectors.toList());
    }

    public LottoRank getRank(LottoNumber winningNumber) {
        return LottoRank.find(matchNumberCount(winningNumber));
    }

    private long matchNumberCount(LottoNumber winnerLottoNumber) {
        return winnerLottoNumber.getNumbers().stream().filter(numbers::contains).count();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void assertValidNumbers(List<Integer> numbers) {
        assertSize(numbers);
        assertValidRange(numbers);
        assertUnique(numbers);
    }

    private void assertSize(List<Integer> numbers) {
        if (numbers.size() < LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(LESS_THAN_NUMBER_COUNT_ERROR);
        }

        if (numbers.size() > LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(GRATER_THAN_NUMBER_COUNT_ERROR);
        }
    }

    private void assertValidRange(List<Integer> numbers) {
        long invalidRangeNumberCount = numbers
                .stream()
                .filter(number -> number > MAX_NUMBER || number < MIN_NUMBER)
                .count();

        if (invalidRangeNumberCount > 0) {
            throw new IllegalArgumentException(INVALID_RANGE_NUMBER_ERROR);
        }
    }

    private void assertUnique(List<Integer> numbers) {
        Set<Integer> uniqueNumberSet = new HashSet<>(numbers);
        if (uniqueNumberSet.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER_ERROR);
        }
    }
}
