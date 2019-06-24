package lotto;

import java.util.HashSet;
import java.util.List;

public class LottoNumbers {
    
    public LottoNumbers(List<Integer> numbers) {
        verifyDulicationNumber(numbers);
    }
    
    private void verifyDulicationNumber(List<Integer> numbers) {
        HashSet<Integer> checkNumbers = new HashSet<>(numbers);
        if(checkNumbers.size() < 6) {
            throw new IllegalArgumentException("중복된 숫자는 허용되지 않습니다.");
        }
    }
}
