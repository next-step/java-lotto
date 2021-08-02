package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private final List<LottoNumber> lottoNumbers = new ArrayList<>();

    private static final String IS_NULL_OR_NOT_SIX_ERROR_MESSAGE = "6개의 숫자를 등록해야 합니다.";
    private static final String DUPLICATE_NUMBER_ERROR_MESSAGE = "중복된 숫자가 있습니다.";
    private static final int LIMIT_SIZE = 6;

    public Lotto(List<Integer> numbers) {
        validateNumbers(numbers);
        addLottoNumbers(numbers);
    }

    private void addLottoNumbers(List<Integer> numbers) {
        for(int number : numbers) {
            lottoNumbers.add(new LottoNumber(number));
        }
    }

    private void validateNumbers(List<Integer> numbers) {
        if(isNullOrEmpty(numbers) || numbers.size() != LIMIT_SIZE) {
            throw new IllegalArgumentException(IS_NULL_OR_NOT_SIX_ERROR_MESSAGE);
        }
        if(checkDuplicateNumbers(numbers)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR_MESSAGE);
        }
    }

    private boolean isNullOrEmpty(List<Integer> numbers) {
        return numbers == null || numbers.isEmpty();
    }

    private boolean checkDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> numbersSet = new HashSet<>(numbers);
        return numbersSet.size() != numbers.size();
    }

    public List<LottoNumber> getLottoNumbers() {
        return this.lottoNumbers;
    }

    /*
    private boolean checkNumbersRange(List<Integer> numbers) {
        long count = numbers.stream()
                .filter(number -> number < MIN_NUMBER || number > MAX_NUMBER)
                .count();
        return count >= MIN_NUMBER;
    }
    */
}
