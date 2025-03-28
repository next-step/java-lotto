package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.LottoConfig.LOTTO_NUMBER_SIZE;
import static lotto.LottoConfig.MAX_LOTTO_NUMBER;

public class LottoNumber {
    private final Set<Integer> numbers;

    public LottoNumber(Set<Integer> numbers) {
        if (numbers == null || numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("Lotto requires " + LOTTO_NUMBER_SIZE + " numbers.");
        }

        if (numbers.stream().anyMatch(num -> num < 1 || num > MAX_LOTTO_NUMBER)) {
            throw new IllegalArgumentException("Lotto requires a number between 1 and " + (MAX_LOTTO_NUMBER - 1));
        }

        this.numbers = numbers;
    }

    public Integer intersectCount(LottoNumber other) {
        Set<Integer> intersection = new HashSet<>(numbers);
        intersection.retainAll(other.numbers);
        return intersection.size();
    }

    @Override
    public String toString() {
        List<Integer> numberList = new ArrayList<>(numbers);
        Collections.sort(numberList);
        return numberList.toString();
    }
}
