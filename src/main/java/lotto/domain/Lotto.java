package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {

    private static final String IS_NULL_OR_NOT_SIX_ERROR_MESSAGE = "6개의 숫자를 등록해야 합니다.";
    private static final String DUPLICATE_NUMBER_ERROR_MESSAGE = "중복된 숫자가 있습니다.";
    private static final int LIMIT_SIZE = 6;
    private static final String SEPARATOR = ",";

    private final List<LottoNumber> lottoNumbers = new ArrayList<>();

    public Lotto(final List<Integer> numbers) {
        validateNumbers(numbers);
        addLottoNumber(numbers);
    }

    public static Lotto valueOf(final String input) {
        validateInput(input);
        List<Integer> numbers = splitNumbers(input);
        return new Lotto(numbers);
    }

    private void validateNumbers(final List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty() || numbers.size() != LIMIT_SIZE) {
            throw new IllegalArgumentException(IS_NULL_OR_NOT_SIX_ERROR_MESSAGE);
        }
        if (checkDuplicateNumbers(numbers)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR_MESSAGE);
        }
    }

    private boolean checkDuplicateNumbers(final List<Integer> numbers) {
        Set<Integer> numbersSet = new HashSet<>(numbers);
        return numbersSet.size() != numbers.size();
    }

    private static void validateInput(final String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(IS_NULL_OR_NOT_SIX_ERROR_MESSAGE);
        }
    }

    private static List<Integer> splitNumbers(final String input) {
        String[] dividedNumbers = input.trim().split(SEPARATOR);
        return Arrays.stream(dividedNumbers).map(Integer::parseInt).collect(Collectors.toList());
    }

    private void addLottoNumber(final List<Integer> numbers) {
        Collections.sort(numbers);
        for (int number : numbers) {
            lottoNumbers.add(new LottoNumber(number));
        }
    }

    public List<LottoNumber> getLottoNumbers() {
        return this.lottoNumbers;
    }

    public MatchingCount getMatchingCount(Lotto lotto) {
        MatchingCount matchingCount = new MatchingCount();

        for (LottoNumber lottoNumber : lottoNumbers) {
            matchingCount = lotto.addMatchingCount(lottoNumber, matchingCount);
        }

        return matchingCount;
    }

    private MatchingCount addMatchingCount(final LottoNumber lottoNumber, final MatchingCount matchingCount) {
        if (addMatchingCount(lottoNumber)) {
            return matchingCount.increment();
        }
        return matchingCount;
    }

    public boolean addMatchingCount(LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
    }

}
