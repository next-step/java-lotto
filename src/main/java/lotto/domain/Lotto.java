package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {

    public final List<LottoNumber> lottoNumbers = new ArrayList<>();
    private static final String IS_NULL_OR_NOT_SIX_ERROR_MESSAGE = "6개의 숫자를 등록해야 합니다.";
    private static final String DUPLICATE_NUMBER_ERROR_MESSAGE = "중복된 숫자가 있습니다.";
    private static final int LIMIT_SIZE = 6;
    private static final String SEPARATOR = ",";

    public Lotto(List<Integer> numbers) {
        validateNumbers(numbers);
        addLottoNumber(numbers);
    }

    public Lotto(String input) {
        validateInput(input);
        List<Integer> numbers = splitNumbers(input);
        validateNumbers(numbers);
        addLottoNumber(numbers);
    }

    private void validateNumbers(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty() || numbers.size() != LIMIT_SIZE) {
            throw new IllegalArgumentException(IS_NULL_OR_NOT_SIX_ERROR_MESSAGE);
        }
        if (checkDuplicateNumbers(numbers)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR_MESSAGE);
        }
    }

    private boolean checkDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> numbersSet = new HashSet<>(numbers);
        return numbersSet.size() != numbers.size();
    }

    private void validateInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(IS_NULL_OR_NOT_SIX_ERROR_MESSAGE);
        }
    }

    private List<Integer> splitNumbers(String input) {
        String[] dividedNumbers = input.trim().split(SEPARATOR);
        return Arrays.stream(dividedNumbers).map(Integer::parseInt).collect(Collectors.toList());
    }

    private void addLottoNumber(List<Integer> numbers) {
        Collections.sort(numbers);
        for (int number : numbers) {
            lottoNumbers.add(new LottoNumber(number));
        }
    }

    public List<LottoNumber> getLottoNumbers() {
        return this.lottoNumbers;
    }

    public boolean matchingNumber(LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
    }

}
