package lotto.model;

import java.util.HashSet;
import java.util.List;

public class LottoNumbers {

    static final int MIN = 1;
    static final int MAX = 45;
    final static int LOTTO_NUMBER_SIZE = 6;

    public LottoNumbers(List<Integer> numbers) {
        verifySize(numbers);
        verifyDuplicationNumber(numbers);
        verifyNumberRange(numbers);
    }

    private void verifyNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            verifyNumber(number);
        }
    }

    void verifyNumber(int number) {
        if (number < MIN || number > MAX) {
            throw new IllegalArgumentException("1~45 범위에서만 생성 가능 합니다.");
        }
    }

    private void verifySize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("6개의 숫자만 입력해야 합니다.");
        }
    }

    private void verifyDuplicationNumber(List<Integer> numbers) {
        HashSet<Integer> checkNumbers = new HashSet<>(numbers);
        if (checkNumbers.size() < LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("중복된 숫자는 허용되지 않습니다.");
        }
    }
}
