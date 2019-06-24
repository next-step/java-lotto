package lotto;

import java.util.HashSet;
import java.util.List;

public class LottoNumbers {
    
    public LottoNumbers(List<Integer> numbers) {
        verifySize(numbers);
        verifyDuplicationNumber(numbers);
    }

    private void verifySize(List<Integer> numbers) {
        if(numbers.size() != 6) {
            throw new IllegalArgumentException("6개의 숫자만 입력해야 합니다.");
        }
    }

    private void verifyDuplicationNumber(List<Integer> numbers) {
        HashSet<Integer> checkNumbers = new HashSet<>(numbers);
        if(checkNumbers.size() < 6) {
            throw new IllegalArgumentException("중복된 숫자는 허용되지 않습니다.");
        }
    }
}
