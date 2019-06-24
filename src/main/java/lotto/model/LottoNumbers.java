package lotto.model;

import java.util.HashSet;
import java.util.List;

public class LottoNumbers {

    private final static int LOTTO_NUMBER_SIZE = 6;
    private List<Integer> numbers;

    public LottoNumbers(List<Integer> numbers) {
        verifySize(numbers);
        verifyDuplicationNumber(numbers);
        this.numbers = numbers;
    }

    private void verifySize(List<Integer> numbers) {
        if(numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("6개의 숫자만 입력해야 합니다.");
        }
    }

    private void verifyDuplicationNumber(List<Integer> numbers) {
        HashSet<Integer> checkNumbers = new HashSet<>(numbers);
        if(checkNumbers.size() < LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("중복된 숫자는 허용되지 않습니다.");
        }
    }
}
