package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumbers {
    private final Set<Integer> numbers;

    public LottoNumbers(Set<Integer> numbers) {
        this(LottoNumbersCondition.getDefaultInstance(), numbers);
    }

    public LottoNumbers(LottoNumbersCondition lottoNumbersCondition, Set<Integer> numbers) {
        lottoNumbersCondition.isSizeValid(numbers);
        lottoNumbersCondition.isNumberValid(numbers);

        this.numbers = numbers;
    }

    public Integer intersectCount(LottoNumbers other) {
        Set<Integer> intersection = new HashSet<>(numbers);
        intersection.retainAll(other.numbers);
        return intersection.size();
    }

    public Set<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        List<Integer> numberList = new ArrayList<>(numbers);
        Collections.sort(numberList);
        return numberList.toString();
    }
}
